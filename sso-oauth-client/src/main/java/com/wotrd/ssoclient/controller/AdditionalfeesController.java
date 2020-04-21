package com.wotrd.ssoclient.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wotrd.ssoclient.pojo.Additionalfees;
import com.wotrd.ssoclient.pojo.Additionalfessjoin;
import com.wotrd.ssoclient.pojo.AdditionlfeeParam;
import com.wotrd.ssoclient.util.HttpClientUtil;
import io.swagger.annotations.*;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 附加费用接口
 */
@Api(tags = "附加费用接口")
@RestController
public class AdditionalfeesController {
    @Autowired
    HttpClientUtil httpClientUtil;

    private static final String DATA_LOCALHOST = "http://localhost:9007";
    @ApiOperation(value = "调用附加费用api")
    @GetMapping("/call/getadditionalfeesall")
    public RequesBean queryStaffPage(){
        return httpClientUtil.get(DATA_LOCALHOST+"/additionalfees/getadditionalfeesall",RequesBean.class);
    }

    @ApiOperation(value = "附加费用添加")

    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query", name = "nid", value = "处方id ",
                    required = true
            ),
            @ApiImplicitParam(
                    paramType = "query", name = "pcsJson", value = "添加的信息 ",
                    required = true
            )
    })
    @GetMapping("/call/additionalfeesSave")
    public RequesBean additionalfeesSave(@RequestParam("nid")Integer nid,String pcsJson)throws Exception{

        String testEncode = URLEncoder.encode(pcsJson, "utf-8" );

        return httpClientUtil.get(DATA_LOCALHOST+"/additionalfees/additionalfeesSave?nid="+nid
                +"&pcoJson="+testEncode,RequesBean.class);
    }
}
