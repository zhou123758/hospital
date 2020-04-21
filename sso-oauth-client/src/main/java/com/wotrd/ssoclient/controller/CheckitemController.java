package com.wotrd.ssoclient.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wotrd.ssoclient.util.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.wotrd.pojo.utils.RequesBean;
import io.swagger.models.auth.In;
import org.bouncycastle.util.StringList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 检查项目接口
 */
@Api(tags = "检查项目接口")
@RestController
public class CheckitemController {
    @Autowired
    HttpClientUtil httpClientUtil;

    private static final String DATA_LOCALHOST = "http://localhost:9007";

    @ApiOperation(value = "检查项目分页查询",notes = "分页查询检查项目")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType = "query",name="pageIndex",value = "当前页数，必填",required = true,defaultValue = "1"),
            @ApiImplicitParam( paramType = "query",name ="checkitemtstatus",value = "项目状态，1启用，2禁用",defaultValue = ""),
            @ApiImplicitParam( paramType = "query",name = "checkitemnameORcheckitemno",value = "项目名称或项目编号",defaultValue = "")
    })
    @GetMapping("/call/querycheckitemparampage")
    public RequesBean queryStaffPage(@RequestParam(value = "pageIndex",defaultValue = "1")String pageIndex,
                                     String checkitemtstatus,String checkitemnameORcheckitemno){
        return httpClientUtil.get(DATA_LOCALHOST+"/checkitem/querycheckitemparampage?pageIndex="+pageIndex
                +"&checkitemtstatus="+checkitemtstatus+"&checkitemnameORcheckitemno="+checkitemnameORcheckitemno,RequesBean.class);
    }

    @GetMapping("/call/savejiancha")
    @ApiOperation(value = "处方检查项目保存",notes = "处方检查项目保存接口")
    public RequesBean saveJianCha(@RequestParam String pcsJson)throws Exception{
        String testEncode = URLEncoder.encode(pcsJson, "utf-8" );
        return httpClientUtil.get(DATA_LOCALHOST+"/savejc/saveJiancha?"
        +"&pcsJson="+testEncode,RequesBean.class);
    }
//    @ApiOperation(value = "检查项目保存",notes = "检查项目和处方保存")
//    @ApiImplicitParam(paramType = "query",name = "pid",value = "处方id，必填",required = true)
//
//    @GetMapping("/call/checkitemadd")
//    public RequesBean checkitemAdd(@RequestParam("pid")Integer pid,
//                                   @RequestParam(value = "cid",required = true) List<Integer> cidlist){
//        RequesBean requesBean = null;
//        for(Integer cid:cidlist){
//            requesBean = httpClientUtil.get(DATA_LOCALHOST+"/checkitem/checkitemadd?pid="+pid
//                    +"&cid="+cid,RequesBean.class);
//        }
//        return requesBean;
//    }
//    @ApiOperation(value = "测试",notes = "测试")
//    @GetMapping("/call/list1")
//    public RequesBean list(Integer nid,@RequestParam(value = "list",required = true) List<Integer> list){
//        RequesBean requesBean = null;
//        for (Integer mid:list){
//            System.out.println(mid);
//             requesBean = httpClientUtil.get(DATA_LOCALHOST+"/checkitem/list?nid="+nid+"&mid="+mid,RequesBean.class);
//        }
//        return requesBean;
//    }




}
