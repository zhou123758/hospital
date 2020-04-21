package com.wotrd.data.service;

import com.wotrd.data.pojo.Patient;
import com.wotrd.data.pojo.PatientParam;

import java.util.List;
import java.util.Map;

public interface PatientService {
    /**
     * 患者信息分页查询
     * @param patientParam
     * @return
     */
    List<Patient> queryPatientParamPage(PatientParam patientParam);
}
