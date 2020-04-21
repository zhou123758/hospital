package com.wotrd.data.controller;

import com.wotrd.data.pojo.Prescription;
import com.wotrd.data.service.PrescriptionService;
import com.wotrd.pojo.utils.RequesBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    PrescriptionService prescriptionService;
    @GetMapping("/us")
    public RequesBean us(){
        return RequesBean.ok("123");
    }
    /**
     * 新增就诊信息
     * @return
     */
    @GetMapping("/prescriptionadd")
    public RequesBean prescriptionAdd(Prescription prescription, HttpServletRequest request){
        try {
            boolean flag = prescriptionService.pescriptionAdd(prescription);
            if(flag){
                log.info("新增主键id:{}",prescription.getId());
                return RequesBean.ok("保存就诊信息成功",prescription.getId());
            }else{
                return RequesBean.error("保存就诊信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("保存就诊系统异常",e.getMessage());
        }
    }
}
