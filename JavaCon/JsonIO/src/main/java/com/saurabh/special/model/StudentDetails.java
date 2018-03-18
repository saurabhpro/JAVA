/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.model;

import java.util.List;

public class StudentDetails {
	private int id;
	private String name;
	private String department;
	private List<String> favoriteSports;

	public StudentDetails() {
	}

	public StudentDetails(int id, String name, String department,
	                      List<String> favoriteSports) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.favoriteSports = favoriteSports;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<String> getFavoriteSports() {
		return favoriteSports;
	}

	public void setFavoriteSports(List<String> favoriteSports) {
		this.favoriteSports = favoriteSports;
	}
}