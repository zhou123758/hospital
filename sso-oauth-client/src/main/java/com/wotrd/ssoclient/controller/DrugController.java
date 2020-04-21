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
 * 药品信息查询接口
 */
@Api(tags = "药品信息查询接口")
@RestController
public class DrugController {
    @Autowired
    private HttpClientUtil httpClientUtil;

    private static final String DRUG_LOCALHOST = "http://localhost:9006";
    @ApiOperation(value = "药品查询",notes = "药品信息分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageIndex",value = "当前页数,必填",
                    required = true,defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name = "chargetType",
                    value = "处方类别,1:西成药,2:中药",defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name = "drugstatus",
                    value = "药品状态,1:启用,2:停用,0:全部",defaultValue = "0")
    })
    @GetMapping("/call/querydrugpage")
    public RequesBean queryDrugPage(@RequestParam("pageIndex")String pageIndex,
                                    String chargetType,String drugstatus,String creationtime,
                                    String drugnameordrugnoorvender){
        return httpClientUtil.get(DRUG_LOCALHOST+"/drug/drugpage?pageIndex="+pageIndex
        +"&chargetType="+chargetType+"&drugstatus="+drugstatus+"&creationtime="+creationtime
        +"&drugnameordrugnoorvender="+drugnameordrugnoorvender,RequesBean.class);
    }
}
