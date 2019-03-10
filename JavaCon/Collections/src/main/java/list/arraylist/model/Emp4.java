/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.arraylist.model;

import java.util.Objects;

public class Emp4 {
	public final int id;

	public Emp4(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {

		System.out.println("Inside Equals of main.java.list.arraylist.deadlock.Emp4");

		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Emp4 emp4 = (Emp4) o;
		return id == emp4.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
