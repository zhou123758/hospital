package com.wotrd.clinic.controller;

import com.wotrd.pojo.utils.RequesBean;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @RequestMapping("/users")
    public Authentication getUser(Authentication user){
        return user;
    }

    @GetMapping("/users/{id}")
    public RequesBean get(@PathVariable Integer id){
        Map<String,Object> user = new HashMap<String,Object>();
        user.put("id",id);
        user.put("username","张三");
        user.put("gender","男");
        return RequesBean.ok(user);
    }

}
