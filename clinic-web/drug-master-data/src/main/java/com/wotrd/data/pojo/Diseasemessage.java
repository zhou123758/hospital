package com.wotrd.data.pojo;


/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-15 
 */

public class Diseasemessage  {

	private Long id;

	/** 疾病名称 */
	private String diseasename;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiseasename() {
		return diseasename;
	}

	public void setDiseasename(String diseasename) {
		this.diseasename = diseasename;
	}
}
