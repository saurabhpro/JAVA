package com.saurabh.viewmodel;

import com.saurabh.entity.attendence.AttendanceOfADate;
import com.saurabh.entity.employee.Employee;
import com.saurabh.service.helper.utility.constants.ProjectConstants;
import com.saurabh.service.helper.utility.constants.enums.AttendanceStatusType;
import com.saurabh.service.helper.utility.constants.enums.LeaveType;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Created by kumars on 3/11/2016.
 */
public class WebJSONModel {
	private String empRevalId;
	private String empSalesforceId;
	private String empName;
	private String empEmailId;
	private String empAvgCheckInTimeForMonth;
	private String empAvgCheckOutTimeForMonth;
	private String empAvgWorkHoursForMonth;
	private AttendanceOfADate[] attendanceOfADates;
	private ArrayList<PerDayAttendanceRecord> allDateDetailsList;
	private Boolean empIfClarificationNeeded;

	public WebJSONModel(FinalObjectModel f) {
		setEmpRevalId(f.getEmpId());
		setEmpSalesforceId(f.getSalesForceId());
		setEmpName(f.getName());
		setEmpEmailId(f.getEmailId());

		setEmpAvgCheckInTimeForMonth(f.getAvgInTime());
		setEmpAvgCheckOutTimeForMonth(f.getAvgOutTime());
		setEmpAvgWorkHoursForMonth(f.getAverageNumberOfHoursMonthly());
		setEmpIfClarificationNeeded(f.getIfClarificationNeeded());

		setAttendanceOfADates(f.attendanceOfADate);
		setAllDateDetailsList();
	}

	public WebJSONModel(FinalObjectModel f, String type) {
		this(f);
		setAllDateDetailsList(type);
	}

	public void setAttendanceOfADates(AttendanceOfADate[] attendanceOfADates) {
		this.attendanceOfADates = attendanceOfADates;
	}

	public void setAllDateDetailsList() {
		allDateDetailsList = new ArrayList<>();
		for (AttendanceOfADate attendanceOfADate : attendanceOfADates)
			this.allDateDetailsList.add(new PerDayAttendanceRecord(attendanceOfADate));
	}

	public String getEmpRevalId() {
		return empRevalId;
	}

	public void setEmpRevalId(String empRevalId) {
		this.empRevalId = empRevalId;
	}

	public String getEmpSalesforceId() {
		return empSalesforceId;
	}

	public void setEmpSalesforceId(String empSalesforceId) {
		this.empSalesforceId = empSalesforceId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpAvgCheckInTimeForMonth() {
		return empAvgCheckInTimeForMonth;
	}

	public void setEmpAvgCheckInTimeForMonth(LocalTime a) {
		this.empAvgCheckInTimeForMonth = a.toString();
	}

	public void setEmpAvgCheckInTimeForMonth(String a) {
		this.empAvgCheckInTimeForMonth = a;
	}

	public String getEmpAvgCheckOutTimeForMonth() {
		return empAvgCheckOutTimeForMonth;
	}

	public void setEmpAvgCheckOutTimeForMonth(LocalTime a) {
		this.empAvgCheckOutTimeForMonth = a.toString();
	}

	public void setEmpAvgCheckOutTimeForMonth(String a) {
		this.empAvgCheckOutTimeForMonth = a;
	}

	public String getEmpAvgWorkHoursForMonth() {
		return empAvgWorkHoursForMonth;
	}

	public void setEmpAvgWorkHoursForMonth(LocalTime a) {
		this.empAvgWorkHoursForMonth = a.toString();
	}

	public void setEmpAvgWorkHoursForMonth(String a) {
		this.empAvgWorkHoursForMonth = a;
	}

	public ArrayList<PerDayAttendanceRecord> getAllDateDetailsList() {
		return allDateDetailsList;
	}

	public void setAllDateDetailsList(String Type) {
		this.allDateDetailsList = new ArrayList<>();
		if (Type.equals(ProjectConstants.DISCREPANCY_IN_WORKERS_LIST)) {
			for (AttendanceOfADate attendanceOfADate : attendanceOfADates)
				if (attendanceOfADate.getAttendanceStatusType().equals(AttendanceStatusType.UNACCOUNTED_ABSENCE))
					this.allDateDetailsList.add(new PerDayAttendanceRecord(attendanceOfADate));
				else if (attendanceOfADate.getAttendanceStatusType().equals(AttendanceStatusType.HALF_DAY)
						&& attendanceOfADate.getLeaveTypeForThisDate().equals(LeaveType.NO_LEAVE))
					this.allDateDetailsList.add(new PerDayAttendanceRecord(attendanceOfADate));
		} else if (Type.equals(ProjectConstants.WEEKEND_WORKERS_LIST))
			for (AttendanceOfADate attendanceOfADate : attendanceOfADates)
				if (attendanceOfADate.getAttendanceStatusType().equals(AttendanceStatusType.WEEKEND_HOLIDAY)
						&& attendanceOfADate.getWorkTimeForDay() != null)
					this.allDateDetailsList.add(new PerDayAttendanceRecord(attendanceOfADate));
	}

	public Boolean getEmpIfClarificationNeeded() {
		return empIfClarificationNeeded;
	}

	public void setEmpIfClarificationNeeded(Boolean empIfClarificationNeeded) {
		this.empIfClarificationNeeded = empIfClarificationNeeded;
	}

	private void displayBasicDetails() {
		System.out.println("\n" + ProjectConstants.EMP_REVAL_IND_ID + " : " + getEmpRevalId());
		System.out.println(ProjectConstants.EMP_FINANCIAL_FORCE_ID + " : " + getEmpSalesforceId());
		System.out.println(ProjectConstants.EMP_NAME + " : " + getEmpName());
		System.out.println(ProjectConstants.EMP_EMAIL_ID + " : " + getEmpEmailId());
		System.out.println(ProjectConstants.EMP_AVERAGE_MONTHLY_CHECK_IN + " : " + getEmpAvgCheckInTimeForMonth());
		System.out.println(ProjectConstants.EMP_AVERAGE_MONTHLY_CHECK_OUT + " : " + getEmpAvgCheckOutTimeForMonth());
		System.out.println(ProjectConstants.EMP_AVERAGE_MONTHLY_WORK_HOURS + " : " + getEmpAvgWorkHoursForMonth());
		System.out.println(ProjectConstants.CLARIFICATION_NEEDED + " : " + getEmpIfClarificationNeeded());

	}

	public void displayAllDates() {
		displayBasicDetails();
		getAllDateDetailsList().forEach(PerDayAttendanceRecord::displaySub);

	}

	public HolidayWorkerModel getHolidayWorkerObjForThisDate(int date) {
		PerDayAttendanceRecord s = allDateDetailsList.get(date);
		if (s.getCheckIn() != null)
			return new HolidayWorkerModel(new Employee(empName, empRevalId, empSalesforceId, empEmailId), s);

		return null;
	}

	static class PerDayAttendanceRecord {
		final String currentDate;
		final AttendanceStatusType attendanceStatusType;
		final LeaveType leaveTypeForThisDate;
		String checkIn;
		String checkOut;
		String workTimeForDay;

		PerDayAttendanceRecord(AttendanceOfADate attendance) {
			currentDate = attendance.getCurrentDate().toString();
			if (attendance.getCheckIn() != null)
				checkIn = attendance.getCheckIn().toString();
			if (attendance.getCheckOut() != null)
				checkOut = attendance.getCheckOut().toString();
			if (attendance.getWorkTimeForDay() != null)
				workTimeForDay = attendance.getWorkTimeForDay().toString();
			attendanceStatusType = attendance.getAttendanceStatusType();
			leaveTypeForThisDate = attendance.getLeaveTypeForThisDate();

			if (checkIn == null)
				checkIn = ProjectConstants.UNDEFINED;
			if (checkOut == null)
				checkOut = ProjectConstants.UNDEFINED;
			if (workTimeForDay == null)
				workTimeForDay = ProjectConstants.UNDEFINED;
		}

		public String getCurrentDate() {
			return currentDate;
		}

		public String getCheckIn() {
			return checkIn;
		}

		public String getCheckOut() {
			return checkOut;
		}

		public String getWorkTimeForDay() {
			return workTimeForDay;
		}

		public AttendanceStatusType getAttendanceStatusType() {
			return attendanceStatusType;
		}

		public LeaveType getLeaveTypeForThisDate() {
			return leaveTypeForThisDate;
		}

		public void displaySub() {
			System.out.println(ProjectConstants.CURRENT_DATE + " : " + getCurrentDate());
			System.out.println(ProjectConstants.EMP_CHECK_IN + " : " + getCheckIn());
			System.out.println(ProjectConstants.EMP_CHECK_OUT + " : " + getCheckOut());
			System.out.println(ProjectConstants.EMP_WORK_HOURS_FOR_THIS_DAY + " : " + getWorkTimeForDay());
			System.out.println(ProjectConstants.EMP_ATTENDANCE_STATUS_TYPE + " : " + getAttendanceStatusType());
			System.out.println(ProjectConstants.EMP_LEAVE_REQUEST_TYPE + " : " + getLeaveTypeForThisDate());
		}
	}
}