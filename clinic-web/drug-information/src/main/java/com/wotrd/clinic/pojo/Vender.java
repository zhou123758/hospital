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
public class Vender  implements Serializable {

	private Long id;
	/**
	 * 供药商名称
	 */
	private String venderName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVenderName() {
		return venderName;
	}

	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}
}
