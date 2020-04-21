package com.wotrd.data.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wotrd.data.pojo.Patient;
import com.wotrd.data.pojo.PatientParam;
import com.wotrd.data.service.PatientService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 患者
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @ApiOperation(value = "分页查询患者",notes = "分页查询患者信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageIndex",value = "当前页数，必填",required = true,defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name = "viplevel",value = "vip等级 1:非会员、2:VIP1、3:VIP2、4:VIP3、5:VIP4"
            ,defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name = "creationtime",value = "创建时间"),
            @ApiImplicitParam(paramType = "query",name = "patientnameORphone",value = "患者的姓名或者手机号码")
    })
    @GetMapping("/querypatientparampage")
    public RequesBean queryPatientParamPage(@RequestParam(value = "pageIndex",defaultValue = "1")String pageIndex,
                                            PatientParam patientParam){
        try {
            if(patientParam.getCreationtime().equals("null")){
                patientParam.setCreationtime("");
            }
            if(patientParam.getPatientnameORphone().equals("null")){
                patientParam.setPatientnameORphone("");
            }
            if(patientParam.getViplevel().equals("null")){
                patientParam.setViplevel("");
            }
            PageHelper.startPage(Integer.parseInt(pageIndex),5);
            List<Patient> patients = patientService.queryPatientParamPage(patientParam);
            PageInfo<Patient> pageInfo = new PageInfo<Patient>(patients);
            return RequesBean.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("系统异常",e);
        }
    }
}

