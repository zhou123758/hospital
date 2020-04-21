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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * github第三方登录控制器
 */
@Controller
@Slf4j
public class GitHubLoginController {
    @Value("${gitub.client.id}")
    private String clientId;
    @Value("${gitub.client.secret}")
    private String clientSecret;
    @Value("${gitub.clinet.redirect}")
    private String clinetRedirect;
    @Value("${gitub.client.url}")
    private String clientUrl;

    @GetMapping("/githubgetcode")
    public void getcode(HttpServletResponse response){

        try {
            String url = clientUrl+"/login/oauth/authorize?client_id="+clientId+
                    "&redirect_uri="+ clinetRedirect+"&scope=user&state=1";
            response.sendRedirect(url);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取授权码失败",e);
        }
    }
    @GetMapping("/githublogin")
    public String callback(@RequestParam("code") String code, @RequestParam("state")String state){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;

        try {
            httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(clientUrl+"/login/oauth/access_token");
            //构造post参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("code",code));
            list.add(new BasicNameValuePair("state",state));
            list.add(new BasicNameValuePair("redirect_uri",clinetRedirect));
            list.add(new BasicNameValuePair("client_id",clientId));
            list.add(new BasicNameValuePair("client_secret",clientSecret));
            HttpEntity entity = new UrlEncodedFormEntity(list);
            httpPost.setEntity(entity);
            httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");
            httpPost.addHeader("accept","application/json");
            //发送请求，获取响应
            response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity());
            log.info("响应结果:{}",result);
            if(response.getStatusLine().getStatusCode()==200){
                RequesBean requesBean = RequesBean.ok((Object) result);
                log.info(requesBean.getData().toString());
                JSONObject jsonObject = JSONObject.parseObject(requesBean.getData().toString());
                String access_token = jsonObject.getString("access_token");
                return "redirect:/githubgetuser?access_token="+access_token;
            }else {
                log.error("获取access_token失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取access_token失败",e);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
            HttpClientUtils.closeQuietly(response);
        }
        return "error";
    }
    @ResponseBody
    @GetMapping("/githubgetuser")
    public RequesBean getuser(String access_token){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;

        try {
            httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet("https://api.github.com/user?access_token="+access_token);
            httpGet.addHeader("Content-Type", "application/json");
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");
            //发送请求获取响应
            response = httpClient.execute(httpGet);
            String result = EntityUtils.toString(response.getEntity());
            log.info("响应结果:{}",result);
            if(response.getStatusLine().getStatusCode()==200){
                return RequesBean.ok((Object)result);
            }else{
                return RequesBean.error("获取用户信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("系统异常");
        } finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }


    }
}
