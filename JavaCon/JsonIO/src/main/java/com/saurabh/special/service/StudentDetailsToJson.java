/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.service;

import com.saurabh.special.api.JsonWriter;
import com.saurabh.special.model.StudentDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saurabhkumar on 09/09/17.
 */
public class StudentDetailsToJson implements JsonMapper {

	@Override
	public void map(String fileName) {
		//Create a new StudentDetails object
		StudentDetails studentDetails = new StudentDetails();

		//set value to its properties
		studentDetails.setName("Saurabh");
		studentDetails.setId(1);
		studentDetails.setDepartment("Science");

		List<String> favoriteSports = new ArrayList<>();
		favoriteSports.add("Cricket");
		favoriteSports.add("Tennis");
		favoriteSports.add("Football");

		studentDetails.setFavoriteSports(favoriteSports);

		//create the json file
		JsonWriter.writeUsingJackson(fileName, studentDetails);

		System.out.println("JSON Write successful!!");

	}
}
