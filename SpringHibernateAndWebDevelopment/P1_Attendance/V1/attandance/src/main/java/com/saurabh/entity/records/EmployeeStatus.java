package com.saurabh.entity.records;

import com.saurabh.entity.employee.Employee;
import com.saurabh.service.helper.utility.constants.enums.EmploymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeStatus {

	private final Employee employee;
	private LocalDate dateOfJoining;
	private LocalDate dateOfLeavingCompany = LocalDate.MAX;
	private boolean isNotInCompanyAnymore = false;
	private EmploymentStatus employmentStatus = EmploymentStatus.CURRENT_EMP;

	@Autowired
	public EmployeeStatus(Employee employee) {
		this.employee = employee;
	}

	public LocalDate getDateOfLeavingCompany() {
		return dateOfLeavingCompany;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public boolean isNotInCompanyAnymore() {
		return isNotInCompanyAnymore;
	}

	public EmploymentStatus getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(EmploymentStatus employmentStatus, LocalDate dateOfLeavingCompany) {
		this.employmentStatus = employmentStatus;

		if (employmentStatus != EmploymentStatus.CURRENT_EMP) {
			this.dateOfLeavingCompany = dateOfLeavingCompany;
			this.isNotInCompanyAnymore = true;
		}
	}

	@Override
	public String toString() {
		return "EmployeeStatus{" +
				"dateOfJoining=" + dateOfJoining +
				", dateOfLeavingCompany=" + dateOfLeavingCompany +
				", isNotInCompanyAnymore=" + isNotInCompanyAnymore +
				", employmentStatus=" + employmentStatus +
				", employee=" + employee +
				'}';
	}
}
