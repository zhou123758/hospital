package com.wotrd.data.service;

import com.wotrd.data.pojo.Medicaladvice;
import io.swagger.models.auth.In;

import java.util.List;

public interface MedicaladviceService {
    List<Medicaladvice> getMedicaladviceAll();

    boolean medicaladviceSave(Integer nid, Integer mid)throws Exception;
}
