package com.saurabh.service;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by saurabhkumar on 09/09/17.
 */
@SuppressWarnings("FieldCanBeLocal")
public class JsonToStudentDetailsMapperTest {

	private final String incoming = "src/main/resources/StudentDetails.json";
	private final String outgoing = "StudentDetails.json";    //location - @module->root

	@Test
	public void map() throws Exception {
		JsonMapper jsonMapper = new JsonToStudentDetailsMapper();
		jsonMapper.map(incoming);
	}

	@Test
	public void writeToJson() throws IOException {
		JsonMapper jsonMapper = new StudentDetailsToJson();
		jsonMapper.map(outgoing);
	}

}