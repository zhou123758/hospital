package com.wotrd.data.dao;

import com.wotrd.data.pojo.Diseasemessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiseasemessageDao {
    List<Diseasemessage> getDiseasemessageAll();

    boolean diseasemessageAdd(@Param("nid")Integer nid,@Param("did")Integer did)throws Exception;
}
