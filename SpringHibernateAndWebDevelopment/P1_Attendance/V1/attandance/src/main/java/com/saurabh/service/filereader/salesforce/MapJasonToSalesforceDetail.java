package com.saurabh.service.filereader.salesforce;

import com.saurabh.api.json.JsonReader;

/**
 * Created by saurabhkumar on 10/09/17.
 */
public class MapJasonToSalesforceDetail {
	public AllEmployeeSalesforceDetailList map(String fileName) {
		return JsonReader.getJSONObjectFromFileUsingJackson(fileName, AllEmployeeSalesforceDetailList.class);
	}
}
