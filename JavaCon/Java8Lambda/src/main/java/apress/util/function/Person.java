/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

// Person.java
package apress.util.function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static apress.util.function.Gender.FEMALE;
import static apress.util.function.Gender.MALE;

public class Person {
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private Gender gender;

	public Person(String firstName, String lastName, LocalDate dob, Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
	}

	// A utility method
	public static List<Person> getPersons() {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("John", "Jacobs", LocalDate.of(1975, 1, 20), MALE));
		list.add(new Person("Wally", "Inman", LocalDate.of(1965, 9, 12), MALE));
		list.add(new Person("Donna", "Jacobs", LocalDate.of(1970, 9, 12), FEMALE));
		return list;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + ", " + gender + ", " + dob;
	}
}
