package com.wotrd.ssoclient.controller;

import com.wotrd.ssoclient.util.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 患者查询
 */
@Api(tags = "患者查询接口")
@RestController
public class PatientController {
    @Autowired
    HttpClientUtil httpClientUtil;

    private static final String DATA_LOCALHOST = "http://localhost:9007";
    @ApiOperation(value = "分页查询患者",notes = "分页查询患者信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageIndex",value = "当前页数，必填",required = true,defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name = "viplevel",value = "vip等级 1:非会员、2:VIP1、3:VIP2、4:VIP3、5:VIP4"
                    ,defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name = "creationtime",value = "创建时间"),
            @ApiImplicitParam(paramType = "query",name = "patientnameORphone",value = "患者的姓名或者手机号码")
    })
    @GetMapping("/call/querypatientparampage")
    public RequesBean queryPatientParamPage(@RequestParam(value = "pageIndex",defaultValue = "1")String pageIndex,
                                            String viplevel,String creationtime,String patientnameORphone){
        return httpClientUtil.get(DATA_LOCALHOST+"/patient/querypatientparampage?pageIndex="+pageIndex
                +"&viplevel="+viplevel+"&creationtime="+creationtime+"&patientnameORphone="+patientnameORphone,RequesBean.class);
    }
}
