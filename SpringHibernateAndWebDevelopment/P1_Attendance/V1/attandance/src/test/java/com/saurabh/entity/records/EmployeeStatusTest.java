package com.saurabh.entity.records;

import com.saurabh.entity.employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeStatusTest {

	private EmployeeStatus employeeStatus;

	@BeforeEach
	void setUp() {
		employeeStatus = new EmployeeStatus(new Employee("Saurabh", "R139", "2000", "saurabh@ec.com"));
	}

	@Test
	void getDateOfJoiningCompany() {
		System.out.println(employeeStatus.getDateOfJoining());
	}

	@Test
	void getEmploymentStatus() {
		System.out.println(employeeStatus.getEmploymentStatus());
	}

	@Test
	void testToString() {
		System.out.println(employeeStatus);
	}

}