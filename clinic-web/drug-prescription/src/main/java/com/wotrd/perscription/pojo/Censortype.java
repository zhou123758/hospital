package com.wotrd.perscription.pojo;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-14 
 */


public class Censortype  {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectTypeName() {
		return projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}

	private Long id;

	private String projectTypeName;

}
