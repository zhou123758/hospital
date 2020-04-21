package com.wotrd.clinic.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-14 
 */

@Setter
@Getter
public class Drug implements Serializable {

	private Long id;

	/** 药品编号 */
	private String drugcoding;

	/** 药品名称 */
	private String drugname;

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
	private String creationtime;

	/** 项目分类 */
	private Long type;
	/**
	 * 收费类别类
	 */
	private Chargetype chargetype;
	/**
	 * 药品状态类
	 */
	private Drugstatus drugstatus;

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

	public Chargetype getChargetype() {
		return chargetype;
	}

	public void setChargetype(Chargetype chargetype) {
		this.chargetype = chargetype;
	}

	public Drugstatus getDrugstatus() {
		return drugstatus;
	}

	public void setDrugstatus(Drugstatus drugstatus) {
		this.drugstatus = drugstatus;
	}

	public Vender getVender() {
		return vender;
	}

	public void setVender(Vender vender) {
		this.vender = vender;
	}

	public Jtype getJtype() {
		return jtype;
	}

	public void setJtype(Jtype jtype) {
		this.jtype = jtype;
	}

	public Xtype getXtype() {
		return xtype;
	}

	public void setXtype(Xtype xtype) {
		this.xtype = xtype;
	}

	public Ztype getZtype() {
		return ztype;
	}

	public void setZtype(Ztype ztype) {
		this.ztype = ztype;
	}

	/**
	 * 供药商名称类
	 */
	private Vender vender;
	/**
	 * 检查分类
	 */
	private Jtype jtype;
	/**
	 * 西药分类
	 */
	private Xtype xtype;
	/**
	 * 中药分类
	 */
	private Ztype ztype;


	@Override
	public String toString() {
		return "id"+id+",drugcoding"+drugcoding
				+",drugname"+drugname+",repertory"+repertory
		+",purchaseprice"+purchaseprice;
	}
}
