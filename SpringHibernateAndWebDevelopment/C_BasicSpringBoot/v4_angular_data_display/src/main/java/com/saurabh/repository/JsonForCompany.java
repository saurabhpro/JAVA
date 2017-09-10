package com.saurabh.repository;

import com.saurabh.entity.AllEmpDetails;
import com.saurabh.entity.EmployeeDetails;
import com.saurabh.api.json.JsonReader;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saurabhkumar on 09/09/17.
 */

@Component
public class JsonForCompany {

	private final String[] listOfEmployeeToShow = {"R137", "R139", "R136"};


	public AllEmpDetails map(String fileName) {

		//Read and map data to employeeDetailLists object
		return JsonReader.getJSONObjectFromFileUsingJackson(fileName, AllEmpDetails.class);
	}

	/**
	 * this method uses json simple
	 * @deprecated use the jackson one
	 */
	@Deprecated
	public List<EmployeeDetails> getEmployeeDetails(String fileName) {
		List<EmployeeDetails> employeeDetailsList = new ArrayList<>();

		JSONObject jsonObject = JsonReader.getJSONObjectFromFile(fileName);

		for (String empID : listOfEmployeeToShow) {
			assert jsonObject != null;
			JSONObject ob = (JSONObject) jsonObject.get(empID);
			EmployeeDetails employeeDetails = getEmployeeDetailsObject(ob);

			employeeDetailsList.add(employeeDetails);
		}

		return employeeDetailsList;
			/*JSONArray companyList = (JSONArray) jsonObject.get("Company List");

			System.out.println("Name: " + name);
			System.out.println("Author: " + author);
			System.out.println("\nCompany List:");

			for (String aCompanyList : (Iterable<String>) companyList) {
				System.out.println(aCompanyList);
			}
			*/
	}

	@Deprecated
	private EmployeeDetails getEmployeeDetailsObject(JSONObject ob) {
		String sID = (String) ob.get("salesForceId");
		String eID = (String) ob.get("empId");
		String name = (String) ob.get("name");
		String emailID = (String) ob.get("emailId");

		return new EmployeeDetails(name, eID, sID, emailID);
	}
}
