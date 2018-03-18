/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.collectors;

import streams.model.DataProvider;
import streams.model.Employee;
import streams.model.Person;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorSummingInt {
	public static void main(String[] args) {


		List<Employee> employees = DataProvider.getEmplolyeeList();

		// Compute sum of salaries of employee
		int total = employees.stream().mapToInt(Employee::getSalary).sum();

		/*
		int total = employees.stream()
						.collect(Collectors.summingInt(Employee::getSalary));
		 */


		System.out.println("Total Salary : " + total);


		/* Explanation: `.mapToInt(Person::getAge)` / `.mapToInt(person -> person.getAge())`
		 * In this operation we are calling method `getQuantity()` on each object of `Item` in List.
         * That returns the `IntStream` of value(Quantity) of all object in List.
         * And we are doing summation of all quantity
         */
		List<Person> personList = DataProvider.getYoungPersonList();

		IntStream totalQuantity = personList.stream()
				.mapToInt(Person::getAge);

		int totalAge = totalQuantity.sum();

        /* Print the total quantity */
		System.out.println("Total Age: " + totalAge);


		// with this we cant leverage the awesome methods on intstream
		Stream<Integer> onlyMap = personList.stream()
				.map(Person::getAge);

	}
}
