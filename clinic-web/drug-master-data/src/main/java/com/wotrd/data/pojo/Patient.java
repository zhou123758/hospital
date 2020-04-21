package com.wotrd.data.pojo;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-15 
 */

public class Patient  {

	private Long id;

	/** 患者编码 */
	private String patientno;

	/** 患者姓名 */
	private String patientname;

	/** 性别 */
	private String sex;

	/** 年龄 */
	private String age;

	/** 手机号码 */
	private String phone;

	/** 会员等级编号 */
	private Long viplevel;

	/** 创建时间 */
	private String creationtime;

	/** 操作人员 */
	private String operator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientno() {
		return patientno;
	}

	public void setPatientno(String patientno) {
		this.patientno = patientno;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getViplevel() {
		return viplevel;
	}

	public void setViplevel(Long viplevel) {
		this.viplevel = viplevel;
	}

	public String getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Viplevel getViplevelObj() {
		return viplevelObj;
	}

	public void setViplevelObj(Viplevel viplevelObj) {
		this.viplevelObj = viplevelObj;
	}

	/**
	 * 会员等级类
	 */
	private Viplevel viplevelObj;

}
