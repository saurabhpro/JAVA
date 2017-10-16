/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package streams;

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
