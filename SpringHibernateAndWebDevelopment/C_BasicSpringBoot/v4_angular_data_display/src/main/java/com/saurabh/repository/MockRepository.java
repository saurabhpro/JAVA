package com.saurabh.repository;

import com.saurabh.entity.AllEmpDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by saurabhkumar on 09/09/17.
 */
@Repository
public class MockRepository {

	private final JsonForCompany jsonForCompany;

	@Autowired
	public MockRepository(JsonForCompany jsonForCompany) {
		this.jsonForCompany = jsonForCompany;
	}

	public AllEmpDetails getEmployeeDetails() {
		String fileName = "src/main/resources/data_mock/Emails.json";

		System.out.println(fileName);

		return jsonForCompany.map(fileName);
		//return jsonForCompany.getEmployeeDetails(fileName);
	}
}
