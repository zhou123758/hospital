package com.wotrd.data.pojo;


/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-17 
 */

public class Prescription  {


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDoctorsid() {
		return doctorsid;
	}

	public void setDoctorsid(Long doctorsid) {
		this.doctorsid = doctorsid;
	}

	public Long getPatientid() {
		return patientid;
	}

	public void setPatientid(Long patientid) {
		this.patientid = patientid;
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

	public Long getSex() {
		return sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
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

	public Long getDiseaseid() {
		return diseaseid;
	}

	public void setDiseaseid(Long diseaseid) {
		this.diseaseid = diseaseid;
	}

	public Long getMedicaladvice() {
		return medicaladvice;
	}

	public void setMedicaladvice(Long medicaladvice) {
		this.medicaladvice = medicaladvice;
	}

	public Long getAdditionalfeesid() {
		return additionalfeesid;
	}

	public void setAdditionalfeesid(Long additionalfeesid) {
		this.additionalfeesid = additionalfeesid;
	}

	public Long getChufangbiao() {
		return chufangbiao;
	}

	public void setChufangbiao(Long chufangbiao) {
		this.chufangbiao = chufangbiao;
	}

	/** 处方表id */
	private Long id;

	/** 医生id */
	private Long doctorsid;

	/** 患者id */
	private Long patientid;

	/** 患者卡号 */
	private String cardnumber;

	/** 患者年龄 */
	private Long age;

	/** 出生日期 */
	private String dateofbirth;

	/** 性别 0女 1男 */
	private Long sex;

	/** 手机号码 */
	private String phone;

	/** 身份证号码 */
	private String idcard;

	/** 地址 */
	private String address;

	/** 详细地址 */
	private String detailedaddress;

	/** 疾病编号 */
	private Long diseaseid;

	/** 医嘱编号 */
	private Long medicaladvice;

	/** 附加费用编号 */
	private Long additionalfeesid;

	/** 处方表id */
	private Long chufangbiao;

}
