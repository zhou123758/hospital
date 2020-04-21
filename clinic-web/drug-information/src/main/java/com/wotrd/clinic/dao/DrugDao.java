package com.wotrd.clinic.dao;

import com.wotrd.clinic.pojo.Drug;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DrugDao {
    /**
     * 药品信息分页查询
     * @return
     */
    List<Drug> quertDrugPage(Map<String,Object> param);

    int quertDrugCount(Map<String,Object> param);
}
