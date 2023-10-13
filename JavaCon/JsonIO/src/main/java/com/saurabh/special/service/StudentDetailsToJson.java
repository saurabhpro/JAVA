/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.service;

import com.saurabh.special.api.JsonWriter;
import com.saurabh.special.model.StudentDetails;

import java.util.List;

/**
 * Created by saurabhkumar on 09/09/17.
 */
public class StudentDetailsToJson implements JsonMapper {

    @Override
    public void map(String fileName) {
        //Create a new StudentDetails object
        var studentDetails = new StudentDetails.Builder();

        //set value to its properties
        studentDetails.setName("Saurabh")
                .setId(1)
                .setDepartment("Science");

        var favoriteSports = List.of("Cricket", "Tennis", "Football");

        studentDetails.setFavoriteSports(favoriteSports);

        //create the json file
        JsonWriter.writeUsingJackson(fileName, studentDetails.build());

        System.out.println("JSON Write successful!!");

    }
}
