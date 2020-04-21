package com.wotrd.data.service;

import com.wotrd.data.pojo.Diseasemessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiseasemessageService {
    List<Diseasemessage> getDiseasemessageAll();

    boolean diseasemessageAdd(Integer nid, Integer did)throws Exception;
}
