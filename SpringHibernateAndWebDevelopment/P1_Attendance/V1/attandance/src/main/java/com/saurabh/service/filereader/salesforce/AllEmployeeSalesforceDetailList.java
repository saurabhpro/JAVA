package com.saurabh.service.filereader.salesforce;

import com.saurabh.entity.records.EmployeeSalesforce;
import com.saurabh.service.filereader.FileReaderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by saurabhkumar on 10/09/17.
 */
public final class AllEmployeeSalesforceDetailList implements FileReaderModel<EmployeeSalesforce> {
	// Map to store the record read from Financial Force File with Reval Salesforce Id as the key
	private Map<String, EmployeeSalesforce> employeeSalesforceDetailsMap;

	@Override
	public List<EmployeeSalesforce> getAsList() {
		return new ArrayList<>(employeeSalesforceDetailsMap.values());
	}

	@Override
	public Map<String, EmployeeSalesforce> getAsMap() {
		return employeeSalesforceDetailsMap;
	}

	@Override
	public void setAsMap(Map<String, EmployeeSalesforce> employeeSalesforceDetailsMap) {
		this.employeeSalesforceDetailsMap = employeeSalesforceDetailsMap;
	}


	@Override
	public String toString() {
		return "AllEmployeeSalesforceDetailList{" +
				"employeeBiometricDetailsList=" + employeeSalesforceDetailsMap +
				'}';
	}
}
