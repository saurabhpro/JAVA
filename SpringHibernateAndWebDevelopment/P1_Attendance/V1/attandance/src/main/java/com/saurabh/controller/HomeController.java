package com.saurabh.controller;

import com.saurabh.entity.employee.Employee;
import com.saurabh.service.DescrepencyWalaService;
import com.saurabh.service.EmployeeBasicsService;
import com.saurabh.service.EverythingBhejoService;
import com.saurabh.service.WeekendPeKaamKarneWalaService;
import com.saurabh.viewmodel.WebJSONModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by saurabhkumar on 06/09/17.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class HomeController {

	private EmployeeBasicsService employeeBasicsService;
	private DescrepencyWalaService descrepencyWalaService;
	private WeekendPeKaamKarneWalaService weekendPeKaamKarneWalaService;
	private EverythingBhejoService everythingBhejoService;

	@Autowired
	public HomeController(EmployeeBasicsService employeeBasicsService, DescrepencyWalaService descrepencyWalaService, WeekendPeKaamKarneWalaService weekendPeKaamKarneWalaService, EverythingBhejoService everythingBhejoService) {
		this.employeeBasicsService = employeeBasicsService;
		this.descrepencyWalaService = descrepencyWalaService;
		this.weekendPeKaamKarneWalaService = weekendPeKaamKarneWalaService;
		this.everythingBhejoService = everythingBhejoService;
	}

	@GetMapping("/emp")
	public List<Employee> showAllEmployeeJson() {
		return employeeBasicsService.getAllEmployeesBasucDetails();
	}

	@GetMapping("/desc")
	public List<WebJSONModel> showEmployeeDescrepancies() {
		return descrepencyWalaService.getOnlyDescrepenciesList();
	}

	@GetMapping("/week")
	public List<WebJSONModel> showEmployeeWhoWorkedOnWeekend() {
		return weekendPeKaamKarneWalaService.getWeekendWorkersList();
	}

	@GetMapping("/allb")
	public List<WebJSONModel> showAllEmployeeBasicList() {
		return everythingBhejoService.getAllEmployees();
	}

	@GetMapping("/all")
	public List<WebJSONModel> showAllEmployeeDetails() {
		return everythingBhejoService.getAllEmployees();
	}
}
