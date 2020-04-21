package com.wotrd.perscription.pojo;


/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-14 
 */

public class Template  {

	private Long id;

	private String name;

	private String diagnose;

	private Long prescriptionType;

	private Long permission;

	private String creationTime;

	private String creater;

	private String templateId;

	private String explain;

	private Prescriptiontype prescriptiontypeObj;

	private Permission permissionObj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public Long getPrescriptionType() {
		return prescriptionType;
	}

	public void setPrescriptionType(Long prescriptionType) {
		this.prescriptionType = prescriptionType;
	}

	public Long getPermission() {
		return permission;
	}

	public void setPermission(Long permission) {
		this.permission = permission;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public Prescriptiontype getPrescriptiontypeObj() {
		return prescriptiontypeObj;
	}

	public void setPrescriptiontypeObj(Prescriptiontype prescriptiontypeObj) {
		this.prescriptiontypeObj = prescriptiontypeObj;
	}

	public Permission getPermissionObj() {
		return permissionObj;
	}

	public void setPermissionObj(Permission permissionObj) {
		this.permissionObj = permissionObj;
	}
}
