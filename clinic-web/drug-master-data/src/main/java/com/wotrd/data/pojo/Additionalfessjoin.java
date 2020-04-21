package com.wotrd.data.pojo;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-17 
 */

public class Additionalfessjoin  implements Serializable {


	/** 处方表和附加费用表 */
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNid() {
		return nid;
	}

	public void setNid(Long nid) {
		this.nid = nid;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/** 处方表id */
	private Long nid;

	/** 附加费用表 */
	private Long aid;

	/** 数量 */
	private Long num;

	/** 价格 */
	private BigDecimal price;

}
