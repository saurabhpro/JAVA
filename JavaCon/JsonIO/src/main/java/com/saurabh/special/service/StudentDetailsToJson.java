/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
