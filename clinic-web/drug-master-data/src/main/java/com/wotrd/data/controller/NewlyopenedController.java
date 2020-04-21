package com.wotrd.data.controller;

import com.wotrd.data.pojo.Newlyopened;
import com.wotrd.data.service.NewlyopenedService;
import com.wotrd.pojo.utils.RequesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newlyopened")
public class NewlyopenedController {
    @Autowired
    NewlyopenedService newlyopenedService;

    /**
     * 保存就诊记录
     * @param newlyopened
     * @return
     */
    @PostMapping("/newlyopenedsave")
    public RequesBean newlyopenedSave(Newlyopened newlyopened){
        try {
            //附加费用
            newlyopened.setAdditionalfeesid(0L);
            //处方项目
            newlyopened.setProjectid(0L);
            boolean flag = newlyopenedService.newlyopenedSave(newlyopened);
            if(flag){
                return RequesBean.ok("保存成功！");
            }else{
                return RequesBean.error("保存失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("系统异常!",e.getMessage());
        }
    }
}
