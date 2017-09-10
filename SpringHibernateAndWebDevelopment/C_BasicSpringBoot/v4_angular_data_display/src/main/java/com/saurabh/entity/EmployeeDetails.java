package com.saurabh.entity;


public class EmployeeDetails {
	private String name;
	private String empId;
	private String salesForceId;
	private String emailId;

	public EmployeeDetails(String name, String empId, String salesForceId, String emailId) {
		this.name = name;
		this.empId = empId;
		this.salesForceId = salesForceId;
		this.emailId = emailId;
	}

	//Needed for proper POJO - public no args constructor
	public EmployeeDetails() {}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId.toLowerCase();
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalesForceId() {
		return salesForceId;
	}

	public void setSalesForceId(String salesForceId) {
		this.salesForceId = salesForceId;
	}

	@Override
	public String toString() {
		return "EmployeeDetails{" +
				"name='" + name + '\'' +
				", empId='" + empId + '\'' +
				", salesForceId='" + salesForceId + '\'' +
				", emailId='" + emailId + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		EmployeeDetails that = (EmployeeDetails) o;

		return getEmpId().equals(that.getEmpId());
	}

	@Override
	public int hashCode() {
		return getEmpId().hashCode();
	}

}
