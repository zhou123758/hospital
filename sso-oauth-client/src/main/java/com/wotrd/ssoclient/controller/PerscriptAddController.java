package com.wotrd.ssoclient.controller;

import com.wotrd.pojo.utils.RequesBean;
import com.wotrd.ssoclient.pojo.Prescription;
import com.wotrd.ssoclient.util.HttpClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "处方保存接口")
@RestController
public class PerscriptAddController {
    @Autowired
    private HttpClientUtil httpClientUtil;

    private static final String PRESCRIPTION = "http://localhost:9007";

    private static final String TEMP = "http://localhost:9008";

    @ApiOperation(value = "处方保存",notes = "处方信息保存")
    @GetMapping("/call/pescriptionadd")
    public RequesBean pescriptionAdd(Prescription prescription){
        RequesBean requesBean =null;
        requesBean = httpClientUtil.get(PRESCRIPTION+"/prescription/prescriptionadd?doctorsid="
        +prescription.getDoctorsid()+"&patientid="+prescription.getPatientid()+"&cardnumber="+prescription.getCardnumber()+
                "&age="+prescription.getAge()+"&dateofbirth="+prescription.getDateofbirth()+"&sex="+prescription.getSex()
        +"&phone="+prescription.getPhone()+"&idcard="+prescription.getIdcard()+"&address="+prescription.getAddress()
        +"&detailedaddress="+prescription.getDetailedaddress(),RequesBean.class);


        return requesBean;
    }
}
