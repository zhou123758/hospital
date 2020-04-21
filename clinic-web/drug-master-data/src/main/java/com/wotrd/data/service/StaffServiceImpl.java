package com.wotrd.data.service;

import com.wotrd.data.dao.StaffDao;
import com.wotrd.data.pojo.Staff;
import com.wotrd.data.pojo.StaffParam;
import com.wotrd.pojo.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffDao staffDao;
    @Override
    public List<Staff> queryStaffParamPage(Page page, StaffParam staffParam) {
        if(page.getPageIndex()<1){
            page.setPageIndex(1);
        }else if(page.getPageIndex()>page.getPageCount()){
            page.setPageIndex(page.getPageCount());
        }
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("from",(page.getPageIndex()-1)*page.getPageSize());
        param.put("pageSize",page.getPageSize());
        param.put("departmentsid",staffParam.getDepartmentsId());
        param.put("staffName",staffParam.getStaffName());
        return staffDao.queryStaffParamPage(param);
    }

    @Override
    public int queryStaffParamCount(StaffParam staffParam) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("departmentsid",staffParam.getDepartmentsId());
        param.put("staffName",staffParam.getStaffName());
        return staffDao.queryStaffParamCount(param);
    }
}
