package com.wotrd.clinic.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

/**
 * 药品条件查询类
 */
@Setter
@Getter
public class QueryParamDrug implements Serializable {
    /**
     * 药品类别
     */
    private String chargetType;
    /**
     * 药品状态
     */
    private String drugstatus;
    /**
     * 创建时间
     */
    private String creationtime;
    /**
     * 药品名称/药品编号/生产厂家
     */
    private String drugnameordrugnoorvender;

    public String getChargetType() {
        return chargetType;
    }

    public void setChargetType(String chargetType) {
        this.chargetType = chargetType;
    }

    public String getDrugstatus() {
        return drugstatus;
    }

    public void setDrugstatus(String drugstatus) {
        this.drugstatus = drugstatus;
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime;
    }

    public String getDrugnameordrugnoorvender() {
        return drugnameordrugnoorvender;
    }

    public void setDrugnameordrugnoorvender(String drugnameordrugnoorvender) {
        this.drugnameordrugnoorvender = drugnameordrugnoorvender;
    }
}
