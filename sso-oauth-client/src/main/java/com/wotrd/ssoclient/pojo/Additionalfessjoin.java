package com.wotrd.ssoclient.pojo;


/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-16 
 */


public class Additionalfessjoin {


	/** 处方表和附加费用表 */
	private Long id;

	/** 处方表id */
	private Long nid;

	/** 附加费用表 */
	private Long aid;

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
}
