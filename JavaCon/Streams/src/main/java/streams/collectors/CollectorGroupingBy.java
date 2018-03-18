/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.collectors;

import streams.model.DataProvider;
import streams.model.Department;
import streams.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorGroupingBy {

	public static void main(String[] args) {
		List<Employee> employees = DataProvider.getEmplolyeeList();

		// Group employees by department
		Map<Department, List<Employee>> byDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		System.out.println("byDept: " + byDept);


		// Compute sum of salaries by department
		Map<Department, Integer> totalByDeptUsingStreams = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.summingInt(Employee::getSalary)));


		Map<Department, Integer> totalByDept = new HashMap<>();
		for (Employee employee : employees) {
			totalByDept.merge(employee.getDepartment(), employee.getSalary(), Integer::sum);
		}


		System.out.println("totalByDept: " + totalByDept);
	}
}
