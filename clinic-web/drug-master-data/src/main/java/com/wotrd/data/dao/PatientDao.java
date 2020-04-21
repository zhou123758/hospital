package com.wotrd.data.dao;

import com.wotrd.data.pojo.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PatientDao {
    /**
     * 患者信息分页查询
     * @param param
     * @return
     */
    List<Patient> queryPatientParamPage(Map<String,Object> param);
}
