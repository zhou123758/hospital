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
public class Ztype  implements Serializable {

	private Long id;

	/** 中药分类 */
	private String ztype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZtype() {
		return ztype;
	}

	public void setZtype(String ztype) {
		this.ztype = ztype;
	}
}
