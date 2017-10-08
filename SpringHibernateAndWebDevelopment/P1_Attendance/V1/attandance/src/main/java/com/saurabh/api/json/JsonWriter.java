package com.saurabh.api.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by saurabhkumar on 09/09/17.
 */
@Component
public class JsonWriter {
	public static <T> void writeUsingJackson(String filePath, T object) {
		//Create a new ObjectMapper, for mapping data to POJO
		ObjectMapper mapper = new ObjectMapper();

		//Set prettyprint option
		mapper.writerWithDefaultPrettyPrinter();


		try {
			//Write the studentDetails data into StudentDetails.json
			mapper.writeValue(new File(filePath), object);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
