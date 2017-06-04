package b_structural.a_adapter.emp;

import b_structural.a_adapter.emp.legacy.Employee;

import java.util.List;

public class AdapterDemo {

	public static void main(String[] args) {
		EmployeeClient client = new EmployeeClient();

		List<Employee> employees = client.getEmployeeList();

		System.out.println(employees);
	}
}
