package com.wotrd.data.pojo;


/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-15 
 */

public class Medicaladvice  {


	private Long id;

	/** 医嘱 */
	private String medicaladvice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedicaladvice() {
		return medicaladvice;
	}

	public void setMedicaladvice(String medicaladvice) {
		this.medicaladvice = medicaladvice;
	}
}
