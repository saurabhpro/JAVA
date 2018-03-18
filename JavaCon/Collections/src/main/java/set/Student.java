/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package set;

import org.jetbrains.annotations.NotNull;

public class Student implements Comparable<Student> {
	int id;
	String fname;
	String lname;

	public Student(int id, String fname, String lname) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Student student = (Student) o;

		return getId() == student.getId();
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", fname='" + fname + '\'' +
				", lname='" + lname + '\'' +
				'}';
	}

	@Override
	public int compareTo(@NotNull Student s) {

		//assert ((o instanceof Student) && (o != null));
		//Student s = (Student) o;
		int relativeValue = lname.compareTo(s.getLname());
		if (relativeValue == 0) {
			relativeValue = fname.compareTo(s.getFname());
		}
		return relativeValue;
	}
}
