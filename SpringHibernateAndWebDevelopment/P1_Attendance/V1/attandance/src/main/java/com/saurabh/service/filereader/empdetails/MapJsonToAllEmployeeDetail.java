package com.saurabh.service.filereader.empdetails;

import com.saurabh.api.json.JsonReader;

/**
 * Created by saurabhkumar on 10/09/17.
 */
public class MapJsonToAllEmployeeDetail {
	public AllEmployeeDetailList map(String fileName) {
		return JsonReader.getJSONObjectFromFileUsingJackson(fileName, AllEmployeeDetailList.class);
	}
}
