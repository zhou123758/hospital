package com.wotrd.data.service;

import com.wotrd.data.dao.PrescriptionDao;
import com.wotrd.data.pojo.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{

    @Autowired
    PrescriptionDao prescriptionDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean pescriptionAdd(Prescription prescription) throws Exception {
        return prescriptionDao.pescriptionAdd(prescription);
    }
}
