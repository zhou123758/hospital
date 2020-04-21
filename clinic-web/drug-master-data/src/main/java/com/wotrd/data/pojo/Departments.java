package com.wotrd.data.pojo;


import java.io.Serializable;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-14 
 */

public class Departments implements Serializable {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartments() {
		return departments;
	}

	public void setDepartments(String departments) {
		this.departments = departments;
	}

	private Long id;

	/** 科室名称 */
	private String departments;

}
