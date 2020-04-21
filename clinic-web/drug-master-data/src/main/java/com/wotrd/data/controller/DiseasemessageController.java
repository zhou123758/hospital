package com.wotrd.data.controller;

import com.wotrd.data.pojo.Diseasemessage;
import com.wotrd.data.service.DiseasemessageServiceImpl;
import io.swagger.annotations.ApiOperation;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diseasemessagea")
public class DiseasemessageController {
    @Autowired
    DiseasemessageServiceImpl diseasemessageService;
    @ApiOperation(value = "查询疾病",notes = "查询疾病全部信息")
    @GetMapping("/getdiseasemessageall")
    public RequesBean getDiseasemessageAll(){
        try {
            List<Diseasemessage> diseasemessages = diseasemessageService.getDiseasemessageAll();
            return RequesBean.ok(diseasemessages);
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("系统异常",e);
        }
    }
    @GetMapping("/diseasemessageAdd")
    public RequesBean diseasemessageAdd(@RequestParam("nid")Integer nid,
                                        @RequestParam("did")Integer did) {
        try {
            boolean flag = diseasemessageService.diseasemessageAdd(nid, did);
            if(flag){
                return RequesBean.ok("疾病保存成功");
            }else{
                return RequesBean.error("疾病保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("疾病保存系统异常",e.getMessage());
        }
    }
}
