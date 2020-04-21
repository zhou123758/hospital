package com.wotrd.data.pojo;

/**
 * 条件查询类
 */
public class StaffParam {
    /**
     * 科室id
     */
    private String departmentsId;

    public String getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(String departmentsId) {
        this.departmentsId = departmentsId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * 员工姓名
     */
    private String staffName;
}
