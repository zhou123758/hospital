package com.wotrd.data.service;

import com.wotrd.data.dao.MedicaladviceDao;
import com.wotrd.data.pojo.Medicaladvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicaladviceServiceImpl implements MedicaladviceService{
    @Autowired
    MedicaladviceDao medicaladviceDao;
    @Override
    public List<Medicaladvice> getMedicaladviceAll() {
        return medicaladviceDao.getMedicaladviceAll();
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean medicaladviceSave(Integer nid, Integer mid) throws Exception {
        return medicaladviceDao.medicaladviceSave(nid,mid);
    }



}
