package com.wotrd.perscription.service;

import com.wotrd.perscription.dao.TemplateDetailDao;
import com.wotrd.perscription.pojo.Templatedetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TemplateDetailServiceImpl implements TemplateDetailService{
    @Autowired
    TemplateDetailDao templateDetailDao;
    @Override
    public List<Templatedetail> Templatedetail(Long tempateId) {
        return templateDetailDao.Templatedetail(tempateId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean temaplateAdd(Templatedetail templatedetail) throws Exception {
        return templateDetailDao.temaplateAdd(templatedetail);
    }
}
