/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.model;

public class Employee {
	private final Department department;
	private final Person person;
	private final int salary;

	public Employee(Person p1, Department Dept, int salary) {
		this.department = Dept;
		this.person = p1;
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public Person getPerson() {
		return person;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"person=" + person +
				'}';
	}

	public int getSalary() {
		return salary;
	}
}
