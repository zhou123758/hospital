package com.wotrd.ssoclient.pojo;


/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-15 
 */


public class Additionalfees {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdditionalfees() {
		return additionalfees;
	}

	public void setAdditionalfees(String additionalfees) {
		this.additionalfees = additionalfees;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	private Long id;

	/** 单次用量 */
	private String additionalfees;

	/** 数量 */
	private Long number;

	/** 价格 */
	private Double price;

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	/*处方类型1西药,2中药*/
	private Long type;
	/*成本*/
	private Double cost;
	/*1允许会员折扣，2不允许会员折扣*/
	private Long discount;

}
