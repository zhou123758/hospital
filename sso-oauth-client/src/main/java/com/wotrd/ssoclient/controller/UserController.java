package com.wotrd.ssoclient.controller;

import com.wotrd.ssoclient.util.HttpClientUtil;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private HttpClientUtil httpClientUtil;

    private static final String CLIENT2_URL = "http://localhost:9006";

    @RequestMapping("/user")
    public Authentication getUser(Authentication user){
        return user;
    }
    @GetMapping("/call/client2/user/{id}")
    public RequesBean callClient2GetUser(@PathVariable("id") Integer id){
        return httpClientUtil.get(CLIENT2_URL+"/api/users/"+id,RequesBean.class);
    }
}
