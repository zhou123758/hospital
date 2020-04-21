package com.wotrd.data.controller;

import com.alibaba.fastjson.JSONObject;
import com.wotrd.data.pojo.Additionalfees;
import com.wotrd.data.pojo.Additionalfessjoin;
import com.wotrd.data.service.AdditionalfeesService;
import io.swagger.annotations.ApiOperation;
import com.wotrd.pojo.utils.RequesBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/additionalfees")
public class AdditionalfeesController {
    @Autowired
    AdditionalfeesService additionalfeesService;

    @GetMapping("/getadditionalfeesall")
    @ApiOperation(value = "调用附加费用api")
    public RequesBean getAdditionalfeesAll(){
        try {
            List<Additionalfees> additionalfees = additionalfeesService.getAdditionalfeesAll();
            return RequesBean.ok(additionalfees);
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("系统异常",e);
        }
    }

    /**
     * 附加费用信息保存
     * @param
     * @return
     */
    @GetMapping("/additionalfeesSave")
    public RequesBean additionalfeesSave(@RequestParam("nid")Long nid, @RequestParam String pcoJson){
        try {
            String testDecode = URLDecoder.decode(pcoJson, "utf-8");
            List<Additionalfessjoin> additionalfessjoins = new ArrayList<Additionalfessjoin>();
            additionalfessjoins = JSONObject.parseArray(testDecode,Additionalfessjoin.class);
            if(additionalfeesService.additionalfeesSave(nid,additionalfessjoins)){
                return RequesBean.ok("附加费用保存成功");
            }else{
                return RequesBean.ok("附加费用保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("附加费用保存系统异常!",e.getMessage());
        }
    }
}
