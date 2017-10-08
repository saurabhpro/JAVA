package com.saurabh.viewmodel;

import com.saurabh.entity.attendence.AttendanceOfADate;
import com.saurabh.entity.attendence.AttendanceOfLeave;
import com.saurabh.entity.employee.Employee;
import com.saurabh.service.filereader.empdetails.EmployeeDetailExcelToObject;
import com.saurabh.service.helper.utility.TimeManager;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

import static com.saurabh.service.helper.utility.constants.ProjectConstants.*;

/**
 * Created by kumars on 2/19/2016.
 */
@Component
public class FinalObjectModel extends Employee {
	private static final long serialVersionUID = 1L;
	// AMRITA
	private final int[] count = new int[5]; // Absent, Present, Public_Holiday, Weekend_Holiday, Half_Day
	public AttendanceOfADate[] attendanceOfADate;
	public List<AttendanceOfLeave> attendanceOfLeaves;
	private LocalTime avgInTime;
	private LocalTime avgOutTime;
	private int numberOfEntriesInHrNet;
	private LocalTime averageNumberOfHoursMonthly;
	private boolean ifClarificationNeeded = false;

	public FinalObjectModel() {
	}

	public FinalObjectModel(String EmployeeID, int numberOfEntriesInHrNet, AttendanceOfADate[] a, List<AttendanceOfLeave> attendanceOfLeaveList) {
		this.setEmpId(EmployeeID);

		Employee b;
		b = EmployeeDetailExcelToObject.getEmployeeObjectFromId(EmployeeID);

		if (b != null) {
			this.setName(b.getName());
			this.setSalesForceId(b.getSalesForceId());
			this.setEmailId(b.getEmailId());
		}
		this.attendanceOfADate = a;
		this.numberOfEntriesInHrNet = numberOfEntriesInHrNet;
		// this.needClarificationFromEmployee = needClarificationFromEmployee;
		this.attendanceOfLeaves = attendanceOfLeaveList;

		avgInTime = setAvgInTime();
		avgOutTime = setAvgOutTime();
		averageNumberOfHoursMonthly = setAverageNumberOfHoursMonthly();
	}

	public void displayFinalList() {
		System.out.println(EMP_NAME + " : " + this.getName());
		System.out.println(EMP_REVAL_IND_ID + " : " + this.getEmpId());
		System.out.println(EMP_AVERAGE_MONTHLY_CHECK_IN + " : " + this.getAvgInTime());
		System.out.println(EMP_AVERAGE_MONTHLY_CHECK_OUT + " : " + this.getAvgOutTime());
		System.out.println(EMP_AVERAGE_MONTHLY_WORK_HOURS + " : " + this.getAverageNumberOfHoursMonthly());
		System.out.println();

		System.out.println(EMP_NUM_LEAVE_REQUESTED + " : " + this.numberOfEntriesInHrNet);

		if (this.attendanceOfLeaves != null) {
			this.attendanceOfLeaves.forEach(System.out::println);
		}

		// AMRITA
		System.out.println("\nNumber of Unaccounted Absence Days " + this.getCount(0));
		System.out.println("Number of Present Days " + this.getCount(1));
		System.out.println("Number of Public Holidays " + this.getCount(2));
		System.out.println("Number of Weekend Holidays " + this.getCount(3));
		System.out.println("Number of Half Days " + this.getCount(4));

		System.out.println("\nBiometric Data for Each Day: ");
		for (int j = 0; j < getNumberOfDaysConsideredInRespectiveMonth(); j++) {
			System.out.print(this.attendanceOfADate[j].getCurrentDate());
			System.out.print("\t" + EMP_CHECK_IN + " : " + this.attendanceOfADate[j].getCheckIn());
			System.out.print("\t" + EMP_CHECK_OUT + " : " + this.attendanceOfADate[j].getCheckOut());
			System.out.print("\t" + EMP_ATTENDANCE_STATUS_TYPE + " : "
					+ this.attendanceOfADate[j].getAttendanceStatusType() + "\n");
			System.out.print(
					"\t" + EMP_WORK_HOURS_FOR_THIS_DAY + " : " + this.attendanceOfADate[j].getWorkTimeForDay() + "\n");
		}

		System.out.println();
	}

	public LocalTime getAvgInTime() {
		return avgInTime;
	}

	public LocalTime getAvgOutTime() {
		return avgOutTime;
	}

	// only for debugging
	private int getCount(int i) {
		return count[i];
	}

	public boolean getIfClarificationNeeded() {
		return ifClarificationNeeded;
	}

	public void setIfClarificationNeeded(boolean needClarificationFromEmployee) {
		this.ifClarificationNeeded = needClarificationFromEmployee;
	}

	private LocalTime setAvgInTime() {
		return TimeManager.calculateAverageOfTime(EMP_AVERAGE_MONTHLY_CHECK_IN, attendanceOfADate);
	}

	private LocalTime setAvgOutTime() {
		return TimeManager.calculateAverageOfTime(EMP_AVERAGE_MONTHLY_CHECK_OUT, attendanceOfADate);
	}

	private LocalTime setAverageNumberOfHoursMonthly() {
		return TimeManager.calculateAverageTimeOfMonth(this.attendanceOfADate);
	}

	public LocalTime getAverageNumberOfHoursMonthly() {
		return averageNumberOfHoursMonthly;
	}

	public void setCount(int i) {
		count[i] = count[i] + 1;
	}
}
