package com.saurabh.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by saurabhkumar on 09/09/17.
 */

public class JsonReader {

	@SuppressWarnings("TryWithIdenticalCatches")
	public static <T> T getJSONObjectFromFileUsingJackson(String jsonFileName, Class<T> classForMapping) {
		String data;

		//Create a new ObjectMapper, for mapping data to POJO
		ObjectMapper mapper = new ObjectMapper();

		try {
			data = FileUtils.readFileToString(new File(jsonFileName), (Charset) null);

			return mapper.readValue(data, classForMapping);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unused")
	public static JSONObject getJSONObjectFromFileUsingJsonSimple(String filePath) {

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader(filePath));

			return (JSONObject) obj; // problem - we still need to map it manually to our class

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
