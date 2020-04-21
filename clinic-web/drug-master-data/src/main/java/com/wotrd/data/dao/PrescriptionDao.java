package com.wotrd.data.dao;

import com.wotrd.data.pojo.Prescription;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrescriptionDao {
    boolean pescriptionAdd(Prescription prescription);
}
