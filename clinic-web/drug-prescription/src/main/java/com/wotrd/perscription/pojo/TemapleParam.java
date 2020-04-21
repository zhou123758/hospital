package com.wotrd.perscription.pojo;

/**
 * 条件查询参数
 */
public class TemapleParam {
    private String prescriptionId;

    private String permissionId;

    public String getPrescriptionId() {
        return prescriptionId;
    }

    private String tempNameORtempId;

    public String getTempNameORtempId() {
        return tempNameORtempId;
    }

    public void setTempNameORtempId(String tempNameORtempId) {
        this.tempNameORtempId = tempNameORtempId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
