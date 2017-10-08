package com.saurabh.service.combine_logic;

import com.saurabh.entity.attendence.AttendanceOfADate;
import com.saurabh.entity.attendence.AttendanceOfLeave;
import com.saurabh.entity.employee.Employee;
import com.saurabh.entity.records.EmployeeBiometric;
import com.saurabh.entity.records.EmployeeSalesforce;
import com.saurabh.service.filereader.biometricdetails.BiometricFileToObject;
import com.saurabh.service.filereader.salesforce.SalesforceFileToObject;
import com.saurabh.service.helper.EmployeeIDMapper;
import com.saurabh.service.helper.utility.constants.enums.AttendanceStatusType;
import com.saurabh.service.helper.utility.constants.enums.HolidaysList;
import com.saurabh.service.helper.utility.constants.enums.LeaveType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.saurabh.service.helper.utility.constants.ProjectConstants.*;

/**
 * Created by Saurabh on 4/9/2016.
 * Helper Utility class for CombineFile
 *
 * @author Amrita & Saurabh
 * @version 1.5
 * @since 1.3 added boundaryDate for currentMonth efficient leave setting
 */
@Component
final class CombineFileHelperUtility {
	private static final Logger logger = LoggerFactory.getLogger(CombineFileHelperUtility.class);

	private CombineFileHelperUtility() {
	}

	/**
	 * Method to update the Number of Leaves for Each Employee
	 */
	static void updateLeaveTakenAmount(List<EmployeeBiometric> allEmployeeBiometricDetailList) {
		// set number of leaves employee took, who are present in Biometric File
		allEmployeeBiometricDetailList.stream()
				.filter(emp -> EmployeeIDMapper.isSalesForceIdPresentForEmployee(emp.getEmpId()))
				.map(Employee::getEmpId)
				.forEach(CombineFileHelperUtility::setNumberOfLeavesTakenByEmployee);
	}

	/**
	 * Method to update the Holiday [PUBLIC_HOLIDAY] marker for Each Employee
	 */
	static void updatePublicHolidayTag(List<EmployeeBiometric> allEmployeeBiometricDetailList) {
		// set holidays for that month for each employee_modal
		allEmployeeBiometricDetailList.forEach(CombineFileHelperUtility::holidayStatusUpdater);
	}

	/**
	 * Method to process the Biometric File Object and update the unaccounted
	 * absence status to present or half-day with SalesForce object
	 * information
	 */
	static void unaccountedAbsentStatusUpdater(List<EmployeeBiometric> allEmployeeBiometricDetailList) {
		// this worked just fine for January
		allEmployeeBiometricDetailList.stream()
				.filter(emp -> EmployeeIDMapper.isSalesForceIdPresentForEmployee(emp.getEmpId()))
				.forEach(CombineFileHelperUtility::markAbsentToOnLeave);

		// update number of work hours for half day
		// just replace CombineFileHelperUtility with this, if the method is not
		// static in this class
		allEmployeeBiometricDetailList.forEach(CombineFileHelperUtility::setAbsentToUnaccountedOrHalfDayWorkTime);
	}

	private static void setNumberOfLeavesTakenByEmployee(String bEmpID) {

		EmployeeBiometric employeeBiometricDetails = BiometricFileToObject.getAllEmployeeBiometricDetailMap().get(bEmpID);
		Map<String, EmployeeSalesforce> salesForceDetailsMap = SalesforceFileToObject.getSalesforceDetailsMap();

		// setting the number of leaves after counting the list
		final String tempSalesForceId = EmployeeIDMapper.getSalesForceIdFromEmployeeId(bEmpID);

		for (String hr : salesForceDetailsMap.keySet()) {
			if (hr.equals(tempSalesForceId)) {
				int size = salesForceDetailsMap.get(hr).getAttendanceOfLeaveList().size();
				//logger.info("Employee "+ employeeBiometricDetails.getEmpId() + " has taken "+size+" leaves");
				employeeBiometricDetails.setNumberOfEntriesInHrNet(size);
			}
		}


	}

	private static void holidayStatusUpdater(EmployeeBiometric empObj) {
		// set public holiday status
		for (HolidaysList h : HolidaysList.values())
			if (h.getDate().getMonth() == getMONTH() &&
					(h.getDate().getDayOfMonth() < getNumberOfDaysConsideredInRespectiveMonth()))

				empObj.attendanceOfADate[h.getDate().getDayOfMonth() - 1].setAttendanceStatusType(AttendanceStatusType.PUBLIC_HOLIDAY);
	}

	private static void markAbsentToOnLeave(EmployeeBiometric empObj) {
		Set<Map.Entry<String, EmployeeSalesforce>> hrDataSet = SalesforceFileToObject.getSalesforceDetailsMap().entrySet();

		String tempSalesForceId = EmployeeIDMapper.getSalesForceIdFromEmployeeId(empObj.getEmpId());

		// update emoObj using the details from hr
		for (Map.Entry<String, EmployeeSalesforce> hrEntry : hrDataSet) {
			if (tempSalesForceId.equals(hrEntry.getKey())) {
				hrEntry.getValue().getAttendanceOfLeaveList().forEach(leaveInfo -> updateAttendanceUsingLeaveType(leaveInfo, empObj));
			}
		}

		//TODO add case for present in biometric and has entry in salesforce
	}// end of function


	private static void updateAttendanceUsingLeaveType(AttendanceOfLeave hr, EmployeeBiometric empObj) {

		double leaveTime = hr.getAbsenceTime();
		LocalDate tempStart = hr.getStartDate();
		LocalDate tempEnd = hr.getEndDate();
		int boundaryDate = getBiometricFileGenerationDate().getDayOfYear();

		int thisDate;
		while (leaveTime > 0 && tempStart.getMonth().equals(getMONTH()) && tempStart.getDayOfYear() <= boundaryDate) {
			thisDate = tempStart.getDayOfMonth() - 1;

			AttendanceOfADate attendance = empObj.attendanceOfADate[thisDate];

			if (leaveTime == 0.5) {
				attendance.setAttendanceStatusType(AttendanceStatusType.PRESENT);
				// second point of update for Half_Day

			} else if (hr.getLeaveType() == LeaveType.WORK_FROM_HOME_IND) {
				// set work from home as 9 hours
				attendance.setWorkTimeForDay(WORK_HOURS_GIVEN_FOR_WORK_FROM_HOME);
				attendance.setAttendanceStatusType(AttendanceStatusType.PRESENT);
			}

			attendance.setLeaveTypeForThisDate(hr.getLeaveType());

			// update the AttendanceStatusType to ON_LEAVE for leaves applied on salesforce
			if (attendance.getAttendanceStatusType() != AttendanceStatusType.HALF_DAY)
				attendance.setAttendanceStatusType(AttendanceStatusType.ON_LEAVE);

			if (tempStart.equals(tempEnd))
				break;
			leaveTime--;
			tempStart = tempStart.plusDays(1);
		}
	}

	private static void setAbsentToUnaccountedOrHalfDayWorkTime(EmployeeBiometric empObj) {
		AttendanceOfADate attendance;
		for (int i = 0; i < getNumberOfDaysConsideredInRespectiveMonth(); i++) {
			attendance = empObj.attendanceOfADate[i];

			// 06-03-2016 changed the Type from ABSENT to UNACCOUNTED_ABSENCE.
			if (attendance.getAttendanceStatusType() == AttendanceStatusType.ABSENT) {
				attendance.setAttendanceStatusType(AttendanceStatusType.UNACCOUNTED_ABSENCE);
			} else if (attendance.getAttendanceStatusType() == AttendanceStatusType.HALF_DAY) {
				//if case - when employee has half day
				LocalTime time = attendance.getWorkTimeForDay();

				if (time == null)
					attendance.setWorkTimeForDay(WORK_HOURS_FOR_HALF_DAY);
				else if (attendance.getLeaveTypeForThisDate() == LeaveType.WORK_FROM_HOME_IND)
					attendance.setWorkTimeForDay(time.plusHours(WORK_HOURS_FOR_HALF_DAY.getHour()));
			}
		}
	}
}
