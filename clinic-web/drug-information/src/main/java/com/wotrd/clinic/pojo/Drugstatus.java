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
public class Drugstatus  implements Serializable {

	private Long id;

	/** 药品状态 */
	private String status;

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
}
