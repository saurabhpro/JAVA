/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh.special.api;

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
