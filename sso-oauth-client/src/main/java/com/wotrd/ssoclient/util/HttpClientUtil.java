package com.wotrd.ssoclient.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class HttpClientUtil {
    @Autowired
    HttpServletRequest request;
    @Autowired
    ObjectMapper objectMapper;
    @SuppressWarnings({"unchecked","rawtypes"})
    public RequesBean get(String uri,Class responeType){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        try {
            String ssoCookies = (String)request.getAttribute("ssoCookies");
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader("Cookie",ssoCookies);
            response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            //授权过期，需要用户重新授权
            Header contentType = (Header)response.headerIterator("Content-Type").next();
            if(contentType.getValue().startsWith("text/html")){
                return RequesBean.ok("调用目标的授权已经失效，请先重新获取授权<a href='"+uri+"'>授权</a>");
            }
            String result = null;
            if(httpEntity != null){
                result = EntityUtils.toString(httpEntity);
                if(log.isDebugEnabled()){
                    log.debug("响应内容:{}",result);
                }
            }
            if(response.getStatusLine().getStatusCode() == 200){
                JSONObject jsonObject = JSONObject.parseObject(result);
                RequesBean requesBean = RequesBean.ok(jsonObject);
                return requesBean;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        } finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return RequesBean.error("其他错误");
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public RequesBean post(String uri,Class responeType){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        try {
            String ssoCookies = (String)request.getAttribute("ssoCookies");
            HttpPost httpPost = new HttpPost(uri);
            httpPost.addHeader("Cookie",ssoCookies);
            response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            //授权过期，需要用户重新授权
            Header contentType = (Header)response.headerIterator("Content-Type").next();
            if(contentType.getValue().startsWith("text/html")){
                return RequesBean.ok("调用目标的授权已经失效，请先重新获取授权<a href='"+uri+"'>授权</a>");
            }
            String result = null;
            if(httpEntity != null){
                result = EntityUtils.toString(httpEntity);
                if(log.isDebugEnabled()){
                    log.debug("响应内容:{}",result);
                }
            }
            if(response.getStatusLine().getStatusCode() == 200){
                JSONObject jsonObject = JSONObject.parseObject(result);
                RequesBean requesBean = RequesBean.ok(jsonObject);
                return requesBean;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        } finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return RequesBean.error("其他错误");
    }
}
