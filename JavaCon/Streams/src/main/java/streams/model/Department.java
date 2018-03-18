/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.model;

public class Department {
	private final String name;
	private final int strength;

	public Department(String dname, int strength) {
		this.name = dname;
		this.strength = strength;
	}

	@Override
	public String toString() {
		return "Department{" +
				"name='" + name + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public int getStrength() {
		return strength;
	}
}
