package com.wotrd.data.service;

import com.wotrd.data.pojo.Staff;
import com.wotrd.data.pojo.StaffParam;
import com.wotrd.pojo.utils.Page;

import java.util.List;

public interface StaffService {
    /**
     * 员工分页条件查询
     * @return
     */
    List<Staff> queryStaffParamPage(Page page, StaffParam staffParam);

    /**
     * 记录数
     * @return
     */
    int queryStaffParamCount(StaffParam staffParam);
}
