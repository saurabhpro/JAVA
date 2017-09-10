package com.saurabh.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by saurabhkumar on 09/09/17.
 */
public class JsonWriter {

	public static <T> void writeUsingJackson(String filePath, T object) {
		//Create a new ObjectMapper, for mapping data to POJO
		ObjectMapper mapper = new ObjectMapper();

		//Set prettyprint option
		mapper.writerWithDefaultPrettyPrinter();

		//Write the studentDetails data into StudentDetails.json
		try {
			mapper.writeValue(new File(filePath), object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
