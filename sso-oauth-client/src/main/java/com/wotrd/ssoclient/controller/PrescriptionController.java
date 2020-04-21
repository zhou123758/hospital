package com.wotrd.ssoclient.controller;

import com.wotrd.ssoclient.pojo.Prescription;
import com.wotrd.ssoclient.util.HttpClientUtil;
import com.wotrd.pojo.utils.RequesBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处方模板查询
 */
@Api(tags = "处方模板查询接口")
@RestController
public class PrescriptionController {
    @Autowired
    private HttpClientUtil httpClientUtil;

    private static final String PRESCRIPTION = "http://localhost:9008";


    @ApiOperation(value = "处方模板查询",notes = "处方模板信息分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageIndex",
                    value = "当前页数，必填",required = true,defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name = "prescriptionId",
                    value = "处方类型编号 数值类型,1:西/成药处方，2:中药处方，3:检查项目"),
            @ApiImplicitParam(paramType = "query",name = "permissionId",
                    value = "模板权限编号 数值类型，1:私人模板，2:公共模板"),
            @ApiImplicitParam(paramType = "query",name = "tempNameORtempId",
                    value = "模板名称或模板编号")
    })
    @GetMapping("/call/prescription/page")
    public RequesBean queryStaffPage(@RequestParam("pageIndex")String pageIndex,
                                     String prescriptionId,String permissionId,
                                     String tempNameORtempId){
        return httpClientUtil.get(PRESCRIPTION+"/temaple/queryTemaplePage?pageIndex="+pageIndex+
                "&prescriptionId="+prescriptionId+"&permissionId="+permissionId
                +"&tempNameORtempId="+tempNameORtempId,RequesBean.class);
    }

    /**
     *处方模板详情
     * @param id
     * @return
     */
    @ApiOperation(value = "模板详情",notes = "根据模板编号查看详情")
    @ApiImplicitParam(paramType = "path",name = "id",value = "模板编号必填",required = true,defaultValue = "1")
    @GetMapping("/call/Temaplebyid/{id}")
    public RequesBean templateDetail(@PathVariable("id") String id){
        return httpClientUtil.get(PRESCRIPTION+"/temaple/Temaplebyid/"+id,RequesBean.class);
    }

//    @ApiOperation(value = "模板详情",notes = "根据模板编号查看详情")
//    @ApiImplicitParam(paramType = "path",name = "id",value = "模板编号必填",required = true,defaultValue = "1")
//    @GetMapping("/call/Temaplebyid")
//    public RequesBean templateAdd(@RequestParam("nid")Integer nid,@RequestParam("tid")Integer tid){
//        return httpClientUtil.get(PRESCRIPTION+"/temaple/templateadd?nid="+nid
//                +"&tid="+tid,RequesBean.class);
//    }


}
