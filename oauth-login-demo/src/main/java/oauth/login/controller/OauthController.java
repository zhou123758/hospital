package oauth.login.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class OauthController {
    private String ssoServerUrl = "http://localhost:9001";
    private String ssoCallbackUrl = "http://localhost:9005/login";
    private String ssoClientId = "client";
    private String ssoClientSecret = "secret";



    @GetMapping("/oauth2/code")
    public void code(HttpServletResponse response){
        String params ="/oauth/authorize?response_type=code"
                +"&client_id="+ssoClientId
                +"&redirect_uri="+ssoCallbackUrl
                +"&scope=app";
        try {

            response.sendRedirect(ssoServerUrl+params);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }
        log.info("发送请求成功:{}{}",ssoServerUrl,params);
    }
    @GetMapping("/login")
    public String callback(String code,HttpServletResponse resp){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;

        try {
            HttpPost httpPost = new HttpPost(ssoServerUrl+"/oauth/token");

            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("grant_type","authorization_code"));
            list.add(new BasicNameValuePair("scope","app"));
            list.add(new BasicNameValuePair("redirect_uri",ssoCallbackUrl));
            list.add(new BasicNameValuePair("code",code));
            list.add(new BasicNameValuePair("client_id",ssoClientId));
            list.add(new BasicNameValuePair("client_secret",ssoClientSecret));
            log.info("请求参数:{}",list);
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list);
            httpPost.setEntity(formEntity);
            //发送请求
            response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            log.info("响应状态:{}",response.getStatusLine());
            String result = null;
            if(httpEntity!=null){
                result = EntityUtils.toString(httpEntity);
                log.info("响应内容长度:{}",httpEntity.getContentLength());
                log.info("响应内容:{}",result);
            }
            if(response.getStatusLine().getStatusCode() == 200){
                RequesBean requesBean = RequesBean.ok((Object)result);
                log.info("成功获取令牌:{}",requesBean.getData().toString());
                JSONObject jsonObject = JSONObject.parseObject(requesBean.getData().toString());
                String access_token = jsonObject.getString("access_token");
                return "redirect:/call_api?access_token="+access_token;
            }else{
                log.error(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
            HttpClientUtils.closeQuietly(response);
        }
        return "error";
    }
    @GetMapping("/call_api")
    @ResponseBody
    public RequesBean callback(String access_token){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;

        try {
            HttpGet httpGet = new HttpGet("http://localhost:9003/content/list?categoryId=1&access_token="+access_token);
            response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            log.info("响应状态:{}",response.getStatusLine());
            String result = null;
            if(httpEntity!=null){
                result = EntityUtils.toString(httpEntity);
                log.info("响应内容长度:{}",httpEntity.getContentLength());
                log.info("响应内容为:{}",result);
            }
            if(response.getStatusLine().getStatusCode()==200){
                @SuppressWarnings("unchkecked")
                RequesBean requesBean = RequesBean.ok((Object)result);
                log.info("成功获取资源服务:{}",requesBean.getData().toString());
//                JSONObject jsonObject = JSONObject.parseObject(requesBean.getData().toString());
                return RequesBean.ok((Object)result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return RequesBean.error("系统异常");
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
            HttpClientUtils.closeQuietly(response);
        }
        return RequesBean.ok("暂无数据");
    }

}
