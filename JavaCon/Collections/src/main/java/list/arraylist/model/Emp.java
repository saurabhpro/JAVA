/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.arraylist.model;

import java.util.Objects;

/**
 * Created by Saurabh on 9/6/2015.
 */
public class Emp {
	public final int id;
	public final String name;

	public Emp(int x, String st) {
		id = x;
		name = st;
	}

	@Override
	public boolean equals(Object o) {

		System.out.println("Inside Overridden Equals");

		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Emp emp = (Emp) o;
		return id == emp.id &&
				Objects.equals(name, emp.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}

