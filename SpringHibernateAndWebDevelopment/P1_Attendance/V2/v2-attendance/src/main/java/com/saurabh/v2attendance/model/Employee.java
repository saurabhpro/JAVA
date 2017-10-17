package com.saurabh.v2attendance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static com.saurabh.v2attendance.api.helper.utility.constants.ProjectConstants.*;

/**
 * Created by saurabhkumar on 06/09/17.
 */
@Entity
public class Employee {
	private String name;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String empId;

	private String salesForceId;
	private String emailId;

	public Employee(String name, String empId, String salesForceId, String emailId) {
		this.name = name;
		this.empId = empId;
		this.salesForceId = salesForceId;
		this.emailId = emailId;
	}

	public Employee() {
	}

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
		return "\nEmployeeDetails{" +
				EMP_NAME + "='" + empId + '\'' +
				", " + EMP_REVAL_IND_ID + "='" + name + '\'' +
				", " + EMP_FINANCIAL_FORCE_ID + "='" + salesForceId + '\'' +
				", " + EMP_EMAIL_ID + "='" + emailId + '\'' +
				'}';
	}
}
