package com.wotrd.perscription.pojo;

import java.util.Date;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-14 
 */

public class Drug  {


	private Long id;

	/** 药品编号 */
	private String drugcoding;

	/** 药品名称 */
	private String drugname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDrugcoding() {
		return drugcoding;
	}

	public void setDrugcoding(String drugcoding) {
		this.drugcoding = drugcoding;
	}

	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}

	public Long getChargeType() {
		return chargeType;
	}

	public void setChargeType(Long chargeType) {
		this.chargeType = chargeType;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Double getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(Double purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public Double getDrugprice() {
		return drugprice;
	}

	public void setDrugprice(Double drugprice) {
		this.drugprice = drugprice;
	}

	public Long getVenderId() {
		return venderId;
	}

	public void setVenderId(Long venderId) {
		this.venderId = venderId;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getRepertory() {
		return repertory;
	}

	public void setRepertory(String repertory) {
		this.repertory = repertory;
	}

	public String getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	/** 收费类别 */
	private Long chargeType;

	/** 规格 */
	private String specification;

	/** 采购价 */
	private Double purchaseprice;

	/** 售药价 */
	private Double drugprice;

	/** 厂家编号 */
	private Long venderId;

	/** 状态 */
	private Long status;

	/** 库存 */
	private String repertory;

	/** 创建时间 */
	private String  creationtime;

	/** 项目分类 */
	private Long type;

}
