/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package apress.util;// apress.util.function.ComparingObjects.java

import apress.util.function.FunctionUtil;
import apress.util.function.Person;

import java.util.Comparator;
import java.util.List;

public class ComparingObjects {
	public static void main(String[] args) {
		List<Person> persons = Person.getPersons();

		// Sort using the first name
		persons.sort(Comparator.comparing(Person::getFirstName));

		// Print the sorted list
		System.out.println("Sorted by the first name:");
		FunctionUtil.forEach(persons, System.out::println);

		// Sort using the last name, first name, and then DOB
		persons.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName).thenComparing(Person::getDob));

		// Print the sorted list
		System.out.println("\nSorted by the last name, first name, and dob:");
		FunctionUtil.forEach(persons, System.out::println);
	}
}
