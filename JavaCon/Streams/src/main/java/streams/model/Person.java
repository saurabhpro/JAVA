/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.model;


/**
 * @author José Paumard
 */
public class Person {

	private String firstName;
	private String lastName;
	private int age;

	private String country;

	public Person(String firstName, String lastName, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
	}

	public Person() {
	}

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + '}';
	}
}
