package com.wotrd.data.pojo;

import java.io.Serializable;

/**
 * 检查项目条件查询类
 */
public class CheckitemParam implements Serializable {

    /**
     * 项目状态
     */
    private String checkitemtstatus;

    public String getCheckitemtstatus() {
        return checkitemtstatus;
    }

    public void setCheckitemtstatus(String checkitemtstatus) {
        this.checkitemtstatus = checkitemtstatus;
    }

    public String getCheckitemnameORcheckitemno() {
        return checkitemnameORcheckitemno;
    }

    public void setCheckitemnameORcheckitemno(String checkitemnameORcheckitemno) {
        this.checkitemnameORcheckitemno = checkitemnameORcheckitemno;
    }

    /**
     * 项目名称/项目编号
     */
    private String checkitemnameORcheckitemno;
}

