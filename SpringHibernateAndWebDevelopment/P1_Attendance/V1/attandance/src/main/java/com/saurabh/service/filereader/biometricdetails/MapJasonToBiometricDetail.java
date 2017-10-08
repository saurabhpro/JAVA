package com.saurabh.service.filereader.biometricdetails;

import com.saurabh.api.json.JsonReader;

/**
 * Created by saurabhkumar on 10/09/17.
 */
public class MapJasonToBiometricDetail {
	public AllEmployeeBiometricDetailList map(String fileName) {
		return JsonReader.getJSONObjectFromFileUsingJackson(fileName, AllEmployeeBiometricDetailList.class);
	}
}
