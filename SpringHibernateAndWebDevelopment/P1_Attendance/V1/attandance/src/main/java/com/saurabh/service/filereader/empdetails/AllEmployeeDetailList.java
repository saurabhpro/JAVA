package com.saurabh.service.filereader.empdetails;

import com.saurabh.entity.employee.Employee;
import com.saurabh.service.filereader.FileReaderModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by saurabhkumar on 10/09/17.
 */
@Service
public final class AllEmployeeDetailList implements FileReaderModel<Employee> {
	private Map<String, Employee> employeeDetailsMap;

	@Override
	public List<Employee> getAsList() {
		return new ArrayList<>(employeeDetailsMap.values());
	}

	@Override
	public Map<String, Employee> getAsMap() {
		return employeeDetailsMap;
	}

	@Override
	public void setAsMap(Map<String, Employee> employeeDetailsMap) {
		this.employeeDetailsMap = employeeDetailsMap;
	}

	@Override
	public String toString() {
		return "AllEmployeeDetailList{" +
				"employeeDetailsList=" + employeeDetailsMap +
				'}';
	}
}
