/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
