package org.clinic.login.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class GitLoginController {

    @Value("${gitee.client.id}")
    private String clientId;
    @Value("${gitee.client.secret}")
    private String clientSecret;
    @Value("${gitee.client.redirect}")
    private String clientRedirect;
    @Value("${gitee.client.url}")
    private String clientUrl;


    /**
     * 获取code
     */
    @GetMapping("/getcode")
    public void getCode(HttpServletResponse response){
        try {
            String url = clientUrl + "/oauth/authorize?client_id="+clientId+
                    "&redirect_uri="+ URLEncoder.encode(clientRedirect,"utf-8")+
                    "&response_type=code";
            response.sendRedirect(url);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取code失败",e);
        }
    }

    /**
     * 码云授权回调地址
     * @param code
     * @return
     */
    @SuppressWarnings("unchecked")
    @GetMapping("/login")
    public String callback(String code){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(clientUrl+"/oauth/token");
            //构造post参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("grant_type","authorization_code"));
            list.add(new BasicNameValuePair("code",code));
            list.add(new BasicNameValuePair("client_id",clientId));
            list.add(new BasicNameValuePair("redirect_uri",clientRedirect));
            list.add(new BasicNameValuePair("client_secret",clientSecret));
            HttpEntity entity = new UrlEncodedFormEntity(list);
            httpPost.setEntity(entity);
            //发送请求，获取响应
            response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity());
            log.info("响应结果{}",result);
            //根据状态码判断是否成功
            if(response.getStatusLine().getStatusCode()==200){
                RequesBean requesBean = RequesBean.ok((Object) result);
                log.info(requesBean.getData().toString());
                JSONObject jsonObject = JSONObject.parseObject(requesBean.getData().toString());
                String access_token = jsonObject.getString("access_token");
                return "redirect:/getuser?access_token="+access_token;
            }else{
                log.error("获取access_token失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取access_token失败:",e);
        }finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return "error";
    }
    @SuppressWarnings("unchecked")
    @GetMapping("/getuser")
    @ResponseBody
    public RequesBean getUser(String access_token){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;

        try {
            httpClient = HttpClientBuilder.create().build();

            HttpGet httpGet = new HttpGet(clientUrl+"/api/v5/user?access_token="+access_token);
            httpGet.addHeader("Content-type","application/json");
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");
            //发送请求
            response = httpClient.execute(httpGet);
            String result = EntityUtils.toString(response.getEntity());
            log.info("响应结果{}",result);
            //根据http状态码判断是否成功
            if(response.getStatusLine().getStatusCode()==200){
               return  RequesBean.ok((Object) result);
            }else{
                log.error("获取用户信息失败");
                return RequesBean.error("获取用户信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取用户信息失败",e);
            return RequesBean.error("系统异常");
        }finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
    }

}
