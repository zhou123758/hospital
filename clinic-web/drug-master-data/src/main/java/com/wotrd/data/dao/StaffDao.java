package com.wotrd.data.dao;

import com.wotrd.data.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StaffDao {
    /**
     * 员工分页条件查询
     * @return
     */
    List<Staff> queryStaffParamPage(Map<String, Object> param);

    /**
     * 记录数
     * @return
     */
    int queryStaffParamCount(Map<String,Object> param);
}
