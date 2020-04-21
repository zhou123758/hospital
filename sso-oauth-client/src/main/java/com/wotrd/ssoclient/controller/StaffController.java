package com.wotrd.ssoclient.controller;

import com.wotrd.ssoclient.util.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工查询接口
 */
@Api(tags = "员工查询接口")
@RestController
public class StaffController {
    @Autowired
    private HttpClientUtil httpClientUtil;

    private static final String STAFF_LOCALHOST = "http://localhost:9007";
    @ApiImplicitParams(
            {

                    @ApiImplicitParam(paramType = "query",name = "departmentsId",
                            value = "科室编号 1:全科,2:内科,3:外科,4:儿科"),

                    @ApiImplicitParam(paramType = "query",name = "staffName",
                            value = "员工姓名")
            }

    )
    @GetMapping("/call/staff/page")
    public RequesBean queryStaffPage(String pageIndex,
                                     String departmentsId,String staffName){
        return httpClientUtil.get(STAFF_LOCALHOST+"/staff/page?pageIndex="+pageIndex+
                "&departmentsId="+departmentsId+"&staffName="+staffName,RequesBean.class);
    }
}
