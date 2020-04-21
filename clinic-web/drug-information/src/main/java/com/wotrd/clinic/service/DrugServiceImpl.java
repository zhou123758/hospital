package com.wotrd.clinic.service;

import com.wotrd.clinic.dao.DrugDao;
import com.wotrd.clinic.pojo.Drug;
import com.wotrd.pojo.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DrugServiceImpl implements DrugService{
    @Autowired
    DrugDao drugDao;

    @Override
    public List<Drug> quertDrugPage(Page page,
                                    Long chargettypeid,
                                    Long drugstatus,
                                    String creationtime,
                                    String drugnameordrugnoorvender) {

        if(page.getPageIndex()<1){
            page.setPageIndex(1);
        }else if(page.getPageIndex()>page.getPageCount()){
            page.setPageIndex(page.getPageCount());
        }
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("chargetType",chargettypeid);
        param.put("drugstatus",drugstatus);
        param.put("creationtime",creationtime);
        param.put("from",(page.getPageIndex()-1)*page.getPageSize());
        param.put("pageSize",page.getPageSize());
        return drugDao.quertDrugPage(param);
    }

    @Override
    public int quertDrugCount(Page page, Long chargettypeid,
                              Long drugstatus, String creationtime,
                              String drugnameordrugnoorvender) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("chargetType",chargettypeid);
        param.put("drugstatus",drugstatus);
        param.put("creationtime",creationtime);
        return drugDao.quertDrugCount(param);
    }
}
