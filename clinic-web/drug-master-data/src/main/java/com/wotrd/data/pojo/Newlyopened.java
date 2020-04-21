package com.wotrd.data.pojo;


/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-16 
 */
public class Newlyopened  {


	/** 新开就诊id */
	private Long id;

	/** 患者卡号 */
	private String cardnumber;

	/** 患者年龄 */
	private Long age;

	/** 出生日期 */
	private String dateofbirth;

	/** 男 */
	private String sex;

	/** 身份证 */
	private String idcard;

	/** 接诊类型 */
	private Long newlyopenedtype;

	/** 地址 */
	private String address;

	/** 详细地址 */
	private String detailedaddress;

	/** 医嘱 */
	private String medicaladvice;

	/** 诊断 */
	private String diagnosis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Long getNewlyopenedtype() {
		return newlyopenedtype;
	}

	public void setNewlyopenedtype(Long newlyopenedtype) {
		this.newlyopenedtype = newlyopenedtype;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailedaddress() {
		return detailedaddress;
	}

	public void setDetailedaddress(String detailedaddress) {
		this.detailedaddress = detailedaddress;
	}

	public String getMedicaladvice() {
		return medicaladvice;
	}

	public void setMedicaladvice(String medicaladvice) {
		this.medicaladvice = medicaladvice;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Long getAdditionalfeesid() {
		return additionalfeesid;
	}

	public void setAdditionalfeesid(Long additionalfeesid) {
		this.additionalfeesid = additionalfeesid;
	}

	public Long getProjectid() {
		return projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	/** 附加费用编号 */
	private Long additionalfeesid;

	/** 处方项目编号 */
	private Long projectid;

}
