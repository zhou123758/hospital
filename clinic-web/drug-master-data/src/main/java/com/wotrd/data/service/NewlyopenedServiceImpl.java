package com.wotrd.data.service;

import com.wotrd.data.dao.NewlyopenedDao;
import com.wotrd.data.pojo.Newlyopened;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewlyopenedServiceImpl implements NewlyopenedService{
    @Autowired
    NewlyopenedDao newlyopenedDao;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean newlyopenedSave(Newlyopened newlyopened) throws Exception {
        return newlyopenedDao.newlyopenedSave(newlyopened);
    }
}
