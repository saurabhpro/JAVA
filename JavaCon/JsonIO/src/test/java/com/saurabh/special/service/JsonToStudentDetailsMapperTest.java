/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.service;


import org.junit.jupiter.api.Test;

/**
 * Created by saurabhkumar on 09/09/17.
 */
@SuppressWarnings("FieldCanBeLocal")
public class JsonToStudentDetailsMapperTest {

    private final String incoming = "src/main/resources/StudentDetails.json";
    private final String outgoing = "StudentDetails.json";    //location - @module->root

    @Test
    public void map() {
        JsonMapper jsonMapper = new JsonToStudentDetailsMapper();
        jsonMapper.map(incoming);
    }

    @Test
    public void writeToJson() {
        JsonMapper jsonMapper = new StudentDetailsToJson();
        jsonMapper.map(outgoing);
    }
}