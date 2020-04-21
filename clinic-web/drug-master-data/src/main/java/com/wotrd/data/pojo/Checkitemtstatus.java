package com.wotrd.data.pojo;


import java.io.Serializable;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-15 
 */

public class Checkitemtstatus  implements Serializable {


	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/** 检查项目状态 */
	private String status;

}
