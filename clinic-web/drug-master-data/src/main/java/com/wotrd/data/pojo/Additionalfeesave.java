package com.wotrd.data.pojo;


import java.io.Serializable;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-16 
 */

public class Additionalfeesave implements Serializable {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAdditional() {
		return additional;
	}

	public void setAdditional(Long additional) {
		this.additional = additional;
	}

	/** 附加费用保存表id */
	private Long id;

	/** 附加费用id */
	private Long additional;

}
