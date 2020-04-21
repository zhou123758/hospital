package com.wotrd.data.dao;

import com.wotrd.data.pojo.Medicaladvice;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MedicaladviceDao {
    List<Medicaladvice> getMedicaladviceAll();

    boolean medicaladviceSave(@Param("nid")Integer nid, @Param("mid")Integer mid)throws Exception;
}
