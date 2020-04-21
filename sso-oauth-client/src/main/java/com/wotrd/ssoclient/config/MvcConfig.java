package com.wotrd.ssoclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String ssoCookies = "";
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies){
                    ssoCookies += cookie.getName() + "=" + cookie.getValue() + ";";
                }
                request.setAttribute("ssoCookies",ssoCookies);
                return true;
            }
        }).addPathPatterns("/call/**");
    }
}
