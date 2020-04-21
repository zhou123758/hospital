package com.wotrd.perscription.pojo;


/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-14 
 */
public class Permission  {


	private Long permissionId;

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	private String permissionName;

}
