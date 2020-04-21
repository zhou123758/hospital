package com.wotrd.perscription.pojo;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-14 
 */

public class Prescriptiontype  {


	private Long prescriptionId;

	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getPrescriptionName() {
		return prescriptionName;
	}

	public void setPrescriptionName(String prescriptionName) {
		this.prescriptionName = prescriptionName;
	}

	private String prescriptionName;

}
