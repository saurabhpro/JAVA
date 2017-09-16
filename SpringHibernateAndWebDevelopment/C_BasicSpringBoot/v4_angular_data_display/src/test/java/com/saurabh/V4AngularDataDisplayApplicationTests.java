package com.saurabh;

import com.saurabh.entity.AllEmpDetails;
import com.saurabh.entity.EmployeeDetails;
import com.saurabh.repository.JsonForCompany;
import com.saurabh.repository.MockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class V4AngularDataDisplayApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void getEmployeeDetails() throws Exception {
		String fileName = "src/main/resources/data_mock/Emails.json";

		JsonForCompany jsonForCompany = new JsonForCompany();
		AllEmpDetails employeeDetailList = jsonForCompany.map(fileName);

		if (employeeDetailList != null) {
			for(EmployeeDetails employeeDetails: employeeDetailList.getEmployeeDetailsList()){

				System.out.println("\n*** Employee Details ***");

				System.out.println(employeeDetails);
			}

		}
	}

}
