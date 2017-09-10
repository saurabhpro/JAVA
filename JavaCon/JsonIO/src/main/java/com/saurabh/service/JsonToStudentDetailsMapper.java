package com.saurabh.service;

import com.saurabh.api.JsonReader;
import com.saurabh.model.StudentDetails;

/**
 * Created by saurabhkumar on 09/09/17.
 */
public class JsonToStudentDetailsMapper implements JsonMapper {

	@Override
	public void map(String fileName) {
		/**
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
