package com.wotrd.perscription.service;

import com.wotrd.perscription.dao.TemplateDao;
import com.wotrd.perscription.pojo.TemapleParam;
import com.wotrd.perscription.pojo.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TemplateServiceImpl implements TemplateService{
    @Autowired
    TemplateDao templateDao;
    @Override
    public List<Template> queryTemplatePage(TemapleParam temapleParam) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("prescriptionId",temapleParam.getPrescriptionId());
        param.put("permissionId",temapleParam.getPermissionId());
        param.put("tempNameORtempId",temapleParam.getTempNameORtempId());
        return templateDao.queryTemplatePage(param);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean templateAdd(Integer nid, Integer tid)throws Exception {
        return templateDao.templateAdd(nid, tid);
    }
}
