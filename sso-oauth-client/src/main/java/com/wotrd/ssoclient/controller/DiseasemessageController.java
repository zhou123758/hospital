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
 * 疾病查询接口
 */
@Api(tags = "疾病信息查询接口")
@RestController
public class DiseasemessageController {
    @Autowired
    HttpClientUtil httpClientUtil;

    private static final String DATA_LOCALHOST = "http://localhost:9007";
    @ApiOperation(value = "查询疾病",notes = "查询疾病全部信息")
    @GetMapping("/call/getdiseasemessageall")
    public RequesBean queryStaffPage(){
        return httpClientUtil.get(DATA_LOCALHOST+"/diseasemessagea/getdiseasemessageall",RequesBean.class);
    }

    @ApiOperation(value = "保存疾病",notes = "保存疾病和处方信息")
    @ApiImplicitParam(paramType = "query",name = "nid",value = "处方编号,必填",required = true)
    @GetMapping("/call/diseasemessageAdd")
    public RequesBean diseasemessageAdd(@RequestParam("nid")Integer nid,
                                        @RequestParam(value = "did",required = true) List<Integer> didlist){
        RequesBean requesBean = null;
        for(Integer did:didlist){
            requesBean = httpClientUtil.get(DATA_LOCALHOST+"/diseasemessagea/diseasemessageAdd?nid="+nid
                    +"&did="+did,RequesBean.class);
        }
        return requesBean;
    }
}
