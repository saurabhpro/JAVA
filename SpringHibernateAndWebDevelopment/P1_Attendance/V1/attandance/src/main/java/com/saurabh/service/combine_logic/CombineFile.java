package com.saurabh.service.combine_logic;

import com.saurabh.entity.attendence.AttendanceOfLeave;
import com.saurabh.entity.records.EmployeeBiometric;
import com.saurabh.entity.records.EmployeeSalesforce;
import com.saurabh.service.filereader.biometricdetails.BiometricFileToObject;
import com.saurabh.service.filereader.salesforce.SalesforceFileToObject;
import com.saurabh.service.helper.EmployeeIDMapper;
import com.saurabh.service.helper.RevalIdComparator;
import com.saurabh.service.helper.utility.constants.enums.AttendanceStatusType;
import com.saurabh.viewmodel.FinalObjectModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.saurabh.service.helper.utility.constants.ProjectConstants.getMONTH;
import static com.saurabh.service.helper.utility.constants.ProjectConstants.getNumberOfDaysConsideredInRespectiveMonth;

/**
 * Created by kumars on 2/16/2016. 6-03-2016 changed the Type from ABSENT to
 * UNACCOUNTED_ABSENCE.
 *
 * @author Saurabh
 * @version 1.5
 * @since 1.4 added revalidcomparator and loop till getNumberOfDaysConsideredInRespectiveMonth()
 */
public class CombineFile extends FinalObject {
	private static final Logger logger = LoggerFactory.getLogger(CombineFile.class);

	/**
	 * Constructor that initializes the Final Object Map with a Treemap with
	 * string Comparator
	 *
	 * @see FinalObject
	 */
	public CombineFile() {
		EmpCombinedMap = new TreeMap<>(new RevalIdComparator());
	}

	/**
	 * Method that updates Biometric File Object's missing data with information
	 * extracted from Financial Force File
	 *
	 * @see CombineFileHelperUtility
	 */
	public final void combineFiles() {

		List<EmployeeBiometric> employeeBiometricDetailList = BiometricFileToObject.getAllEmployeeBiometricDetailList();
		Map<String, EmployeeSalesforce> salesForceDetailsMap = SalesforceFileToObject.getSalesforceDetailsMap();

		// update the employee_modal in biometric file
		CombineFileHelperUtility.updateLeaveTakenAmount(employeeBiometricDetailList);
		CombineFileHelperUtility.updatePublicHolidayTag(employeeBiometricDetailList);
		CombineFileHelperUtility.unaccountedAbsentStatusUpdater(employeeBiometricDetailList);

		// Combine SalesForce and Biometric Files object
		for (EmployeeBiometric empObj : employeeBiometricDetailList) {
			if (empObj.getNumberOfEntriesInHrNet() == 0) {
				fillCombinedObject(empObj, 0, null);
			} else {
				for (String hrKey : salesForceDetailsMap.keySet()) {
					String tempSalesForceId = EmployeeIDMapper.getSalesForceIdFromEmployeeId(empObj.getEmpId());
					// logger.warn("Employee SalesForceId Not Found for [" + empObj.getEmpId() + " | " + empObj.getName() + "] from " + Thread.currentThread().getStackTrace()[1].getMethodName());

					if (hrKey.equals(tempSalesForceId)) {
						fillCombinedObject(empObj, empObj.getNumberOfEntriesInHrNet(), salesForceDetailsMap.get(hrKey).getAttendanceOfLeaveList());
					}
				}
			}
		}

		EmpCombinedMap.values().forEach(this::countAttendanceStatusType);
	}

	private void fillCombinedObject(EmployeeBiometric empObj, int numberOfLeaveEntriesInSalesforce, List<AttendanceOfLeave> attendanceOfLeaveList) {
		FinalObjectModel model = new FinalObjectModel(empObj.getEmpId(), numberOfLeaveEntriesInSalesforce, empObj.attendanceOfADate, attendanceOfLeaveList);

		EmpCombinedMap.put(empObj.getEmpId(), model);
	}

	/**
	 * Method to display the result of combining Biometric and Financial Force
	 * File Objects
	 */
	public void displayCombineFiles() {
		System.out.println(getMONTH());
		EmpCombinedMap.values().forEach(FinalObjectModel::displayFinalList);
	}

	private void countAttendanceStatusType(FinalObjectModel emp) {
		// to be removed
		for (int j = 0; j < getNumberOfDaysConsideredInRespectiveMonth(); j++) {

			// AMRITA
			if (emp.attendanceOfADate[j].getAttendanceStatusType().equals(AttendanceStatusType.UNACCOUNTED_ABSENCE))
				emp.setCount(0);
			else if (emp.attendanceOfADate[j].getAttendanceStatusType().equals(AttendanceStatusType.PRESENT))
				emp.setCount(1);
			else if (emp.attendanceOfADate[j].getAttendanceStatusType().equals(AttendanceStatusType.PUBLIC_HOLIDAY))
				emp.setCount(2);
			else if (emp.attendanceOfADate[j].getAttendanceStatusType().equals(AttendanceStatusType.WEEKEND_HOLIDAY))
				emp.setCount(3);
			else if (emp.attendanceOfADate[j].getAttendanceStatusType().equals(AttendanceStatusType.HALF_DAY))
				emp.setCount(4);
		}

	}

}