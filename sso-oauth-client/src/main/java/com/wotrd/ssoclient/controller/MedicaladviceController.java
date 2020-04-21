package com.wotrd.ssoclient.controller;

import com.wotrd.ssoclient.util.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.wotrd.pojo.utils.RequesBean;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 医嘱查询接口
 */
@Api(tags = "医嘱查询接口")
@RestController
public class MedicaladviceController {
    @Autowired
    HttpClientUtil httpClientUtil;

    private static final String DATA_LOCALHOST = "http://localhost:9007";

    @ApiOperation(value = "查询医嘱",notes = "查询全部医嘱信息")
    @GetMapping("/call/getmedicaladviceall")
    public RequesBean queryStaffPage(){
        return httpClientUtil.get(DATA_LOCALHOST+"/medicaladvice/getmedicaladviceall",RequesBean.class);
    }

    @ApiOperation(value = "医嘱保存",notes = "医嘱、处方信息保存")
    @ApiImplicitParam(paramType = "query",name = "nid",value = "处方编号,不能为空",required = true)

    @GetMapping("/call/medicaladvicejoinAdd")
    public RequesBean medicaladvicejoinAdd(@RequestParam("nid")Integer nid,
                                           @RequestParam(value = "mid",required = true) List<Integer> midlist){
        RequesBean requesBean = null;
        for(Integer mid:midlist){
            requesBean = httpClientUtil.get(DATA_LOCALHOST+"/medicaladvice/medicaladvicejoinAdd?nid="+nid
                    +"&mid="+mid,RequesBean.class);
        }
        return requesBean;
    }
}
