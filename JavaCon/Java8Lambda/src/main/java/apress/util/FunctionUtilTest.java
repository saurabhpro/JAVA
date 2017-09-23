/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package apress.util;// apress.util.function.FunctionUtilTest.java

import apress.util.function.FunctionUtil;
import apress.util.function.Person;

import java.util.List;

import static apress.util.function.Gender.MALE;

public class FunctionUtilTest {
	public static void main(String[] args) {
		List<Person> list = Person.getPersons();

		// Use the forEach() method to print each person in the list
		System.out.println("Original list of persons:");
		FunctionUtil.forEach(list, p -> System.out.println(p));

		// Filter only males
		List<Person> maleList = FunctionUtil.filter(list, p -> p.getGender() == MALE);

		System.out.println("\nMales only:");
		FunctionUtil.forEach(maleList, p -> System.out.println(p));

		// Map each person to his/her year of birth
		List<Integer> dobYearList = FunctionUtil.map(list, p -> p.getDob().getYear());

		System.out.println("\nPersons mapped to year of their birth:");
		FunctionUtil.forEach(dobYearList, year -> System.out.println(year));

		// Apply an action to each person in the list
		// Add one year to each male's dob
		FunctionUtil.forEach(maleList, p -> p.setDob(p.getDob().plusYears(1)));

		System.out.println("\nMales only after ading 1 year to DOB:");
		FunctionUtil.forEach(maleList, p -> System.out.println(p));
	}
}
