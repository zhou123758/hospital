package com.wotrd.data.service;

import com.wotrd.data.dao.DiseasemessageDao;
import com.wotrd.data.pojo.Diseasemessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiseasemessageServiceImpl implements DiseasemessageService {
    @Autowired
    DiseasemessageDao diseasemessageDao;
    @Override
    public List<Diseasemessage> getDiseasemessageAll() {
        return diseasemessageDao.getDiseasemessageAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean diseasemessageAdd(Integer nid, Integer did)throws Exception {
        return diseasemessageDao.diseasemessageAdd(nid,did);
    }
}
