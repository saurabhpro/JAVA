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

import com.saurabh.special.api.JsonReader;
import com.saurabh.special.model.StudentDetails;

/**
 * Created by saurabhkumar on 09/09/17.
 */
public class JsonToStudentDetailsMapper implements JsonMapper {

	@Override
	public void map(String fileName) {
		/*
		 * only thing that matters is what class we are passing, if we are passing Student details, 
		 * we are assuming only one json object having these properties
		 * 
		 * so to get arrays/lists of students,
		 * Create a new class AllStudents with List<StudentDetails> with getters and setters and pass it
		 * the list name from this class should be present in the json - 
		 * 
		 * like if List<> abc =...;
		 * Json should be like { abc: [{}, {}]	}
		 */
		//Read and map data to studentDetails object
		StudentDetails studentDetails = JsonReader.getJSONObjectFromFileUsingJackson(fileName, StudentDetails.class);

		if (studentDetails != null) {
			//Print the studentdetails
			System.out.println("*** StudentDetails Details ***");

			System.out.println("Student Name        : " + studentDetails.getName());
			System.out.println("Student Id          : " + studentDetails.getId());
			System.out.println("Student Department  : " + studentDetails.getDepartment());
			System.out.println("Favourite Sports : ");

			for (String fav : studentDetails.getFavoriteSports()) {
				System.out.print(fav + " | ");
			}
		}
	}

}
