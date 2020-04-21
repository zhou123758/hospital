package com.wotrd.data.pojo;


import java.math.BigDecimal;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-18 
 */

public class Savejiancha  {

	/** 保存检查项目 */

	private Long id;

	/** 就诊信息id */
	private Long chufangid;

	/** 检查项目名称 */
	private String name;

	/** 数量 */
	private Long num;

	/** 类型 */
	private Long type;

	/** 金额 */
	private BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getChufangid() {
		return chufangid;
	}

	public void setChufangid(Long chufangid) {
		this.chufangid = chufangid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	/** 备注 */
	private String beizhu;

}
