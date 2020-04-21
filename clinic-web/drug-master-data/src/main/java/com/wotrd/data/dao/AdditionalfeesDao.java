package com.wotrd.data.dao;

import com.wotrd.data.pojo.Additionalfees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface AdditionalfeesDao {
    /**
     * 查询附加费用
     * @return
     */
    List<Additionalfees> getAdditionalfeesAll();

    /**
     * 保存附加费用
     * @param
     * @return
     */
    boolean additionalfeesSave(@Param("nid")Long nid, @Param("aid")Long aid,
                               @Param("num")Long num, @Param("price")BigDecimal price)throws Exception;
}
