package com.wotrd.data.pojo;

/**
 * 患者条件查询类
 */
public class PatientParam {
    private String viplevel;

    private String creationtime;

    private String patientnameORphone;

    public String getViplevel() {
        return viplevel;
    }

    public void setViplevel(String viplevel) {
        this.viplevel = viplevel;
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime;
    }

    public String getPatientnameORphone() {
        return patientnameORphone;
    }

    public void setPatientnameORphone(String patientnameORphone) {
        this.patientnameORphone = patientnameORphone;
    }
}
