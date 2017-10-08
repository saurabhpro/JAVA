package com.saurabh.service;

import com.saurabh.entity.employee.Employee;
import com.saurabh.service.filereader.empdetails.EmployeeDetailExcelToObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saurabhkumar on 10/09/17.
 */
@Service
public class EmployeeBasicsService {

	private final EmployeeDetailExcelToObject allEmployeeDetailList;
	private String filePath = "src/main/resources/sample_files/Emails.xlsx";


	@Autowired
	public EmployeeBasicsService(EmployeeDetailExcelToObject allEmployeeDetailList) {
		this.allEmployeeDetailList = allEmployeeDetailList;
	}

	public List<Employee> getAllEmployeesBasucDetails() {
		allEmployeeDetailList.readExcelFile(filePath);

		return EmployeeDetailExcelToObject.getAllEmployeeDetailList();
	}
}
