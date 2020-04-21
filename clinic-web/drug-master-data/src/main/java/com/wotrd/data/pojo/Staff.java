package com.wotrd.data.pojo;


import java.io.Serializable;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-14 
 */

public class Staff implements Serializable {

	private Long id;

	/** 工号 */
	private String staffno;

	/** 员工姓名 */
	private String staffname;

	/** 性别 */
	private String gender;

	/** 年龄 */
	private Long age;

	/** 诊所编号 */
	private Long clinicId;

	/** 科室编号 */
	private Long departmentsid;

	/** 角色 */
	private Long roleId;

	/** 创建时间 */
	private String creationtime;

	/** 创建人员 */
	private String creation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffno() {
		return staffno;
	}

	public void setStaffno(String staffno) {
		this.staffno = staffno;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	public Long getDepartmentsid() {
		return departmentsid;
	}

	public void setDepartmentsid(Long departmentsid) {
		this.departmentsid = departmentsid;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}

	public Long getStatu() {
		return statu;
	}

	public void setStatu(Long statu) {
		this.statu = statu;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public StaffRole getStaffRole() {
		return staffRole;
	}

	public void setStaffRole(StaffRole staffRole) {
		this.staffRole = staffRole;
	}

	/** 员工状态0停工，1启用 */
	private Long statu;

	private String phone;
	/**
	 * 诊所类
	 */
	private Clinic clinic;
	/**
	 * 科室类
	 */
	private Departments departments;
	/**
	 * 角色类
	 */
	private StaffRole staffRole;

}
