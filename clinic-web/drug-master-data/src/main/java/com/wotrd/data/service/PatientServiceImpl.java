package com.wotrd.data.service;

import com.wotrd.data.dao.PatientDao;
import com.wotrd.data.pojo.Patient;
import com.wotrd.data.pojo.PatientParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientDao patientDao;
    @Override
    public List<Patient> queryPatientParamPage(PatientParam patientParam) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("viplevel",patientParam.getViplevel());
        param.put("creationtime",patientParam.getCreationtime());
        param.put("patientnameORphone",patientParam.getPatientnameORphone());
        return patientDao.queryPatientParamPage(param);
    }
}
