package com.wotrd.data.service;

import com.wotrd.data.pojo.Additionalfees;
import com.wotrd.data.pojo.Additionalfessjoin;
import io.swagger.models.auth.In;

import java.util.List;

public interface AdditionalfeesService {
    List<Additionalfees> getAdditionalfeesAll();

    boolean additionalfeesSave(Long nid, List<Additionalfessjoin> additionalfessjoins)throws Exception;
}
