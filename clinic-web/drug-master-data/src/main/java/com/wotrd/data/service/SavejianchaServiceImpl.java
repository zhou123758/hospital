package com.wotrd.data.service;

import com.wotrd.data.dao.SavejianchaDao;
import com.wotrd.data.pojo.Savejiancha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SavejianchaServiceImpl implements SavejianchaService{
    @Autowired
    SavejianchaDao savejianchaDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean savejancha(List<Savejiancha> savejiancha) throws Exception {
        boolean flag = false;
        for (Savejiancha savejiancha1:savejiancha){
            flag =  savejianchaDao.savejancha(savejiancha1);
        }
        return flag;
    }
}
