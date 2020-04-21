package com.wotrd.perscription.pojo;


/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-14 
 */

public class Templatedetail  {


	/** 模板详情id */
	private Long id;

	/** 组号 */
	private Long groupnumber;

	/** 药品编号 */
	private Long drugid;

	/** 用量 */
	private String dosage;

	/** 用法 */
	private String usage;

	/** 频率 */
	private String frequency;

	/** 天数 */
	private String day;

	/** 总量 */
	private String gross;

	/** 单价 */
	private String price;

	public Integer getChufangId() {
		return chufangId;
	}

	public void setChufangId(Integer chufangId) {
		this.chufangId = chufangId;
	}

	/*处方编号*/
	private Integer chufangId;

	private Drug drug;

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupnumber() {
		return groupnumber;
	}

	public void setGroupnumber(Long groupnumber) {
		this.groupnumber = groupnumber;
	}

	public Long getDrugid() {
		return drugid;
	}

	public void setDrugid(Long drugid) {
		this.drugid = drugid;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getGross() {
		return gross;
	}

	public void setGross(String gross) {
		this.gross = gross;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
