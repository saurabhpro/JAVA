package com.saurabh.controllers;

import com.saurabh.entity.AllEmpDetails;
import com.saurabh.service.EmployeeReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by saurabhkumar on 09/09/17.
 */

@RestController
public class HomeController {

	private final EmployeeReadService employeeReadService;

	@Autowired
	public HomeController(EmployeeReadService employeeReadService) {
		this.employeeReadService = employeeReadService;
	}

	@GetMapping("/emp")
	public AllEmpDetails getAllEmployeeDetails() {
		return employeeReadService.getEmployeeDetails();
	}
}
