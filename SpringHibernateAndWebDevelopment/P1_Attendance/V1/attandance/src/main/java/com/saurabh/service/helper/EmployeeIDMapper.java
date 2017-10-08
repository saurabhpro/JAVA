package com.saurabh.service.helper;

import com.saurabh.entity.employee.Employee;
import com.saurabh.service.filereader.empdetails.EmployeeDetailExcelToObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by kumars on 2/29/2016.
 */
public final class EmployeeIDMapper {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeIDMapper.class);
	private static Map<String, Employee> employeeDetailMap = EmployeeDetailExcelToObject.getAllEmployeeDetailMap();


	public static boolean isSalesForceIdPresentForEmployee(String empId) {
		if (employeeDetailMap.containsKey(empId) && employeeDetailMap.get(empId).getSalesForceId() != null) {
			return true;
		} else {
			logger.warn("Employee SalesForceId Not Found for [" + empId + "] from " + Thread.currentThread().getStackTrace()[2].getMethodName());
			return false;
		}
	}

	/**
	 * @param empId The Reval Id for Reval India employees
	 * @return the SalesForce Id returned corresponding to the Reval Id
	 */
	public static String getSalesForceIdFromEmployeeId(String empId) {

		if (isSalesForceIdPresentForEmployee(empId)) {
			return employeeDetailMap.get(empId).getSalesForceId();
		}

		throw new RuntimeException("Something unexpected occurred when trying to map Employee Id -> SalesForce Id");

		/*List<EmployeeDetails> employeeDetailExcelToList = EmployeeDetailExcelToObject.getAllEmployeeDetailList();

		for (EmployeeDetails employeeDetails : employeeDetailExcelToList) {
			if (employeeDetails.getEmpId().equals(empId)) {
				if (employeeDetails.getSalesForceId() != null)
					return employeeDetails.getSalesForceId();
			}
		}*/
	}
}