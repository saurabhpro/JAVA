package com.saurabh.service.filereader.biometricdetails;

import com.saurabh.entity.records.EmployeeBiometric;
import com.saurabh.service.filereader.FileReaderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by saurabhkumar on 10/09/17.
 */
public final class AllEmployeeBiometricDetailList implements FileReaderModel<EmployeeBiometric> {
	// Map to store the record read from Biometric File with Reval Employee Id as the key
	private Map<String, EmployeeBiometric> empBiometricMap;

	@Override
	public Map<String, EmployeeBiometric> getAsMap() {
		return empBiometricMap;
	}

	@Override
	public void setAsMap(Map<String, EmployeeBiometric> empBiometricMap) {
		this.empBiometricMap = empBiometricMap;
	}

	@Override
	public List<EmployeeBiometric> getAsList() {
		return new ArrayList<>(empBiometricMap.values());
	}

	@Override
	public String toString() {
		return "AllEmployeeSalesforceDetailList{" +
				"employeeBiometricDetailsList=" + empBiometricMap +
				'}';
	}
}
