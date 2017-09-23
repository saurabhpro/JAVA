/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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