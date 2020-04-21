package com.wotrd.clinic.controller;

import com.wotrd.clinic.pojo.Drug;
import com.wotrd.clinic.pojo.QueryParamDrug;
import com.wotrd.clinic.report.CreateReport;
import com.wotrd.clinic.service.DrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.wotrd.pojo.utils.Page;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    DrugService drugService;

    @ApiOperation(value = "药品查询",notes = "药品信息分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageIndex",value = "当前页数,必填",
            required = true,defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name = "chargetType",
                    value = "处方类别,1:西成药,2:中药",defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name = "drugstatus",
                    value = "药品状态,1:启用,2:停用,0:全部",defaultValue = "0")
    })
    @GetMapping("/drugpage")
    public RequesBean queryDrugPage(@RequestParam("pageIndex") String pageIndex,
                                    QueryParamDrug queryParamDrug){
        pageIndex = pageIndex==null?"1":pageIndex;
        if(queryParamDrug.getDrugnameordrugnoorvender().equals("null")){
            queryParamDrug.setDrugnameordrugnoorvender("");
        }
        if(queryParamDrug.getChargetType().equals("null")){
            queryParamDrug.setChargetType("0");
        }
        if(queryParamDrug.getCreationtime().equals("null")){
            queryParamDrug.setCreationtime("");
        }
        if(queryParamDrug.getDrugstatus().equals("null")){
            queryParamDrug.setDrugstatus("0");
        }
        Page page = new Page();
        try {
            page.setPageIndex(Integer.parseInt(pageIndex));
            page.setPageSize(2);
            page.setCount(drugService.quertDrugCount(page,
                    Long.parseLong(queryParamDrug.getChargetType()),
                    Long.parseLong(queryParamDrug.getDrugstatus()),
                    queryParamDrug.getCreationtime(),
                    queryParamDrug.getDrugnameordrugnoorvender()));


            page.setList(drugService.quertDrugPage(page,
                    Long.parseLong(queryParamDrug.getChargetType()),
                    Long.parseLong(queryParamDrug.getDrugstatus()),
                    queryParamDrug.getCreationtime(),
                    queryParamDrug.getDrugnameordrugnoorvender()));
            return RequesBean.ok(page.getList());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return RequesBean.error("系统异常",e);
        }
    }

    @GetMapping("/report")
    public void report(HttpServletResponse response,Integer pageIndex) {
        CreateReport report = new CreateReport();
        List<String> headList = Arrays.asList("序号","单号","药品名称","数量","采购成本");
        List<List<String>> dataList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            dataList.add(Arrays.asList("" + i,"1000" + i,"药品" + i,"" +i, "2.55"));
//        }
        Page page = new Page();
        page.setPageSize(2);
        page.setPageIndex(pageIndex);
        page.setCount(drugService.quertDrugCount(page,
                null,
                null,
                "",
                ""));

        List<Drug> drugs = drugService.quertDrugPage(page,
                null,
                null,
                "","");
        for(Drug drug:drugs){
            dataList.add(Arrays.asList("" + drug.getId(),drug.getDrugcoding(),drug.getDrugname(),drug.getRepertory(),drug.getPurchaseprice()+""));
        }
        CreateReport.createWorkBook(null, "a", headList, dataList, response, "报表测试.xls");
    }
}
