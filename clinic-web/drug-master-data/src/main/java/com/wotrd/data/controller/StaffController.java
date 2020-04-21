package com.wotrd.data.controller;

import com.wotrd.data.pojo.Staff;
import com.wotrd.data.pojo.StaffParam;
import com.wotrd.data.service.StaffService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.wotrd.pojo.utils.Page;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    StaffService staffService;
//    @ApiOperation(value = "员工表分页查询",notes = "员工信息分页查询")
//    @ApiImplicitParams(
//            {@ApiImplicitParam(paramType = "query",name = "pegIndex",
//            value = "当前页数，必填",required = true,defaultValue = "1"),
//            @ApiImplicitParam(paramType = "query",name = "departmentsId",
//            value = "科室编号 1:全科,2:内科,3:外科,4:儿科",defaultValue = "1"),
//                    @ApiImplicitParam(paramType = "query",name = "staffName",
//                    value = "员工姓名")
//            }
//    )
    @GetMapping("/page")
    public RequesBean queryStaffParamPage(@RequestParam("pageIndex")String pageIndex,
                                          StaffParam staffParam){
        pageIndex = pageIndex==null?"1":pageIndex;
        if(staffParam.getDepartmentsId()!=null && staffParam.getStaffName()!=null){
            if(staffParam.getDepartmentsId().equals("null")){
                staffParam.setDepartmentsId("");
            }
            if(staffParam.getStaffName().equals("null")){
                staffParam.setStaffName("");
            }
        }

        try {
            Page page = new Page();
            page.setPageIndex(Integer.parseInt(pageIndex));
            page.setPageSize(2);
            page.setCount(staffService.queryStaffParamCount(staffParam));
            if(redisTemplate.hasKey("queryStaffParamPage")){
                page.setList(redisTemplate.opsForList().range("queryStaffParamPage",0,-1));
            }else{
                List<Staff> staffList = staffService.queryStaffParamPage(page,staffParam);
                redisTemplate.opsForList().rightPushAll("queryStaffParamPage",20,staffList);
                page.setList(staffService.queryStaffParamPage(page,staffParam));
            }
            return RequesBean.ok(page.getList());
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("系统异常",e);
        }
    }
}
