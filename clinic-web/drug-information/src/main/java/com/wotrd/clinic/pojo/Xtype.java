package com.wotrd.clinic.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-14 
 */

@Setter
@Getter
public class Xtype implements Serializable {

	private Long id;

	/** 西药分类 */
	private String xtype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getXtype() {
		return xtype;
	}

	public void setXtype(String xtype) {
		this.xtype = xtype;
	}
}
