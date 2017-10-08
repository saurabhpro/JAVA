package com.saurabh.service.combine_logic;

import com.saurabh.api.excel.read.ExcelReader;
import com.saurabh.service.filereader.biometricdetails.BiometricFileToObject;
import com.saurabh.service.filereader.empdetails.EmployeeDetailExcelToObject;
import com.saurabh.service.filereader.salesforce.SalesforceFileToObject;
import com.saurabh.service.helper.utility.constants.ProjectConstants;
import com.saurabh.viewmodel.FinalObjectModel;

import java.time.Month;
import java.time.Year;
import java.util.Map;

/**
 * Created by kumars on 4/19/2016.
 *
 * @author Saurabh
 * @version 1.0
 */
public class FinalObject {
	/**
	 * The Final object where we will store the result of combining and setting
	 * discrepancy flag.
	 */
	static Map<String, FinalObjectModel> EmpCombinedMap;

	//Mock
	static {
		ExcelReader biometricFileToObject = new BiometricFileToObject();
		biometricFileToObject.readExcelFile("src/main/resources/sample_files/may.xls");

		ExcelReader salesforceFileToObject = new SalesforceFileToObject();
		salesforceFileToObject.readExcelFile("src/main/resources/sample_files/FF Report.xlsx");

		ExcelReader employeeDetailExcelToObject = new EmployeeDetailExcelToObject();
		employeeDetailExcelToObject.readExcelFile("src/main/resources/sample_files/Emails.xlsx");

		ProjectConstants.setMONTH(Month.MAY);
		ProjectConstants.setYEAR(Year.of(2016));
	}

	public static Map<String, FinalObjectModel> getEmpCombinedMap() {
		if (EmpCombinedMap == null) {
			FinalObject f = new CombineFile();
			f.combineFiles();

			f = new MarkDiscrepancy();
			f.findDiscrepancy();
		}

		return EmpCombinedMap;
	}

	public void combineFiles() {
	}

	public void findDiscrepancy() {
	}

	public void displayCombineFiles() {
	}
}
