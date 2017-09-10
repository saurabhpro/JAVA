package com.saurabh.api.json;

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

public class JsonReader implements JsonIO {

	public static <T> T getJSONObjectFromFileUsingJackson(String jsonFileName, Class<T> classForMapping) {
		String data;

		//Create a new ObjectMapper, for mapping data to POJO
		ObjectMapper mapper = new ObjectMapper();

		try {
			data = FileUtils.readFileToString(new File(jsonFileName), (Charset) null);

			return mapper.readValue(data, classForMapping);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Deprecated
	public static JSONObject getJSONObjectFromFile(String filePath) {

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader(filePath));

			return (JSONObject) obj;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
