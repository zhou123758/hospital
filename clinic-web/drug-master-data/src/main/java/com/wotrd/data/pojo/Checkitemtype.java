package com.wotrd.data.pojo;



/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-15 
 */

public class Checkitemtype  {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCheckitemtype() {
		return checkitemtype;
	}

	public void setCheckitemtype(String checkitemtype) {
		this.checkitemtype = checkitemtype;
	}

	private Long id;

	/** 项目类别 */
	private String checkitemtype;

}
