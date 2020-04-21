package com.wotrd.data.pojo;


import java.io.Serializable;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-15 
 */


public class Checkitem  implements Serializable {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCheckitemno() {
		return checkitemno;
	}

	public void setCheckitemno(String checkitemno) {
		this.checkitemno = checkitemno;
	}

	public String getCheckitemname() {
		return checkitemname;
	}

	public void setCheckitemname(String checkitemname) {
		this.checkitemname = checkitemname;
	}

	public Long getCheckitemtype() {
		return checkitemtype;
	}

	public void setCheckitemtype(Long checkitemtype) {
		this.checkitemtype = checkitemtype;
	}

	public Long getInvoiceitems() {
		return invoiceitems;
	}

	public void setInvoiceitems(Long invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}

	public Additionalfees getAdditionalfees() {
		return additionalfees;
	}

	public void setAdditionalfees(Additionalfees additionalfees) {
		this.additionalfees = additionalfees;
	}

	public Checkitemtype getCheckitemtypeObj() {
		return checkitemtypeObj;
	}

	public void setCheckitemtypeObj(Checkitemtype checkitemtypeObj) {
		this.checkitemtypeObj = checkitemtypeObj;
	}

	/** 项目编号 */
	private String checkitemno;

	/** 项目名称 */
	private String checkitemname;

	/** 项目类别 */
	private Long checkitemtype;

	/**
	 * 发票项目
	 */
	private Long invoiceitems;

	/** 零售 */
	private Double price;

	/** 成本 */
	private Double cost;

	/** 单位 */
	private String unit;

	/** 项目状态 */
	private String status;

	/** 创建时间 */
	private String creationtime;
	/**
	 *发票项目类
	 */
	private Additionalfees additionalfees;
	/**
	 * 项目类别类
	 */
	private Checkitemtype checkitemtypeObj;

	public Checkitemtstatus getCheckitemtstatus() {
		return checkitemtstatus;
	}

	public void setCheckitemtstatus(Checkitemtstatus checkitemtstatus) {
		this.checkitemtstatus = checkitemtstatus;
	}

	/**
	 * 检查项目状态
	 */
	private Checkitemtstatus checkitemtstatus;

}
