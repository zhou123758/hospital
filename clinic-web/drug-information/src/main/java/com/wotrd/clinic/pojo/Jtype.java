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
public class Jtype  implements Serializable {


	private Long id;

	/** 检查分类 */
	private String jtype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJtype() {
		return jtype;
	}

	public void setJtype(String jtype) {
		this.jtype = jtype;
	}
}
