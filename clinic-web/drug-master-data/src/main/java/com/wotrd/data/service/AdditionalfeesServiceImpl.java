package com.wotrd.data.service;

import com.wotrd.data.dao.AdditionalfeesDao;
import com.wotrd.data.pojo.Additionalfees;
import com.wotrd.data.pojo.Additionalfessjoin;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AdditionalfeesServiceImpl implements AdditionalfeesService{
    @Autowired
    AdditionalfeesDao additionalfeesDao;
    @Override
    public List<Additionalfees> getAdditionalfeesAll() {
        return additionalfeesDao.getAdditionalfeesAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean additionalfeesSave(Long nid,List<Additionalfessjoin> additionalfessjoins)throws Exception {
        boolean flag = false;
        for (Additionalfessjoin additionalfessjoin2:additionalfessjoins){

            flag = additionalfeesDao.additionalfeesSave(nid,additionalfessjoin2.getAid(),
                    additionalfessjoin2.getNum(),additionalfessjoin2.getPrice());
        }
            return flag;
    }
}
