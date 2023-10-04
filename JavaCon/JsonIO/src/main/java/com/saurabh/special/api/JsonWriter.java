/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by saurabhkumar on 09/09/17.
 */
public class JsonWriter {

    private static final Logger LOG = LoggerFactory.getLogger(JsonWriter.class);

    public static <T> void writeUsingJackson(String filePath, T object) {
        //Create a new ObjectMapper, for mapping data to POJO
        ObjectMapper mapper = new ObjectMapper();

        //Set prettyprint option
        mapper.writerWithDefaultPrettyPrinter();

        //Write the studentDetails data into StudentDetails.json
        try {
            mapper.writeValue(new File(filePath), object);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}
