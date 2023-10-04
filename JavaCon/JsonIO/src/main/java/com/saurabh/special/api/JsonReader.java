/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
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

}
