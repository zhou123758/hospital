package com.wotrd.data.controller;

import com.alibaba.fastjson.JSONObject;
import com.wotrd.data.pojo.Additionalfessjoin;
import com.wotrd.data.pojo.Savejiancha;
import com.wotrd.data.service.SavejianchaService;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/savejc")
public class SavejianchaController {
    @Autowired
    SavejianchaService savejianchaService;

    @GetMapping("/saveJiancha")
    public RequesBean saveJianCha(String pcsJson){
        try {
            String testDecode = URLDecoder.decode(pcsJson, "utf-8");
            List<Savejiancha> savejianchaList = new ArrayList<Savejiancha>();
            savejianchaList = JSONObject.parseArray(testDecode,Savejiancha.class);
            boolean flag = savejianchaService.savejancha(savejianchaList);
            if(flag){
                return RequesBean.ok("处方检查项目保存成功");
            }else{
                return RequesBean.error("处方检查项目保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("处方检查项目保存系统异常",e.getMessage());
        }
    }

    @GetMapping("/hello")
    public RequesBean hello(){
      return RequesBean.ok("hello");
    }
}
