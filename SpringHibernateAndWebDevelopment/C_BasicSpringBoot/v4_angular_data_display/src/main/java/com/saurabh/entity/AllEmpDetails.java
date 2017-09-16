package com.saurabh.entity;

import java.util.List;

/**
 * Created by saurabhkumar on 10/09/17.
 */
public class AllEmpDetails {
	public List<EmployeeDetails> getEmployeeDetailsList() {
		return employeeDetailsList;
	}

	public void setEmployeeDetailsList(List<EmployeeDetails> employeeDetailsList) {
		this.employeeDetailsList = employeeDetailsList;
	}

	public List<EmployeeDetails> employeeDetailsList;   //this name wil be used to map json to from array
}
