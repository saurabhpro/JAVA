/**
 * Created by Saurabhk on 08-02-2016.
 */

package com.saurabh.entity.records;

import com.saurabh.entity.attendence.AttendanceOfADate;
import com.saurabh.entity.employee.Employee;

import java.time.LocalTime;

import static com.saurabh.service.helper.utility.constants.ProjectConstants.*;

public class EmployeeBiometric extends Employee {
	public AttendanceOfADate[] attendanceOfADate;
	private int numberOfEntriesInHrNet = 0; // To check how many leaves have
	// been applied

	/**
	 * @param eID               The Reval Employee Id
	 * @param eName             The name of the Employee
	 * @param attendanceOfADate The record of all days attendance
	 */
	public EmployeeBiometric(String eID, String eName, AttendanceOfADate[] attendanceOfADate) {
		super.setName(eName);
		super.setEmpId(eID);
		this.attendanceOfADate = attendanceOfADate;
	}

	/**
	 *
	 */
	public EmployeeBiometric() {
	}

	/**
	 * @return
	 */
	public int getNumberOfEntriesInHrNet() {
		return numberOfEntriesInHrNet;
	}

	/**
	 * @param numberOfEntriesInHrNet
	 */
	public void setNumberOfEntriesInHrNet(int numberOfEntriesInHrNet) {
		this.numberOfEntriesInHrNet = numberOfEntriesInHrNet;
	}


	/**
	 * @deprecated use toString() instead
	 */
	@Deprecated
	public void displayEmpBiometricDetails() {
		System.out.println(EMP_NAME + " : " + this.getName());
		System.out.println(EMP_REVAL_IND_ID + " : " + this.getEmpId());

		LocalTime workTime;

		for (int j = 0; j < getNumberOfDaysConsideredInRespectiveMonth(); j++) {
			System.out.print(CURRENT_DATE + " : " + this.attendanceOfADate[j].getCurrentDate());
			System.out.print("\t" + EMP_CHECK_IN + " : " + this.attendanceOfADate[j].getCheckIn());
			System.out.print("\t+" + EMP_CHECK_OUT + " : " + this.attendanceOfADate[j].getCheckOut());
			System.out.print("\t" + EMP_ATTENDANCE_STATUS_TYPE + " : "
					+ this.attendanceOfADate[j].getAttendanceStatusType() + "\n");

			workTime = this.attendanceOfADate[j].getWorkTimeForDay();
			if (workTime != null)
				System.out.println(EMP_WORK_HOURS_FOR_THIS_DAY + " : " + workTime);

		}

		System.out.println();
	}

	@Override
	public String toString() {
		LocalTime workTime;
		StringBuilder printMessage = new StringBuilder("EmployeeBiometricDetails{\n" + super.toString() + "\n");

		for (int j = 0; j < getNumberOfDaysConsideredInRespectiveMonth(); j++) {
			printMessage.append(CURRENT_DATE + " : ").append(attendanceOfADate[j].getCurrentDate());
			printMessage.append("\t" + EMP_CHECK_IN + " : ").append(attendanceOfADate[j].getCheckIn());
			printMessage.append("\t+" + EMP_CHECK_OUT + " : ").append(attendanceOfADate[j].getCheckOut());
			printMessage.append("\t" + EMP_ATTENDANCE_STATUS_TYPE + " : ").append(attendanceOfADate[j].getAttendanceStatusType()).append("\n");

			workTime = attendanceOfADate[j].getWorkTimeForDay();
			if (workTime != null)
				printMessage.append(EMP_WORK_HOURS_FOR_THIS_DAY + " : ").append(workTime).append("\n");

		}

		return "EmployeeBiometricDetails{\n" + printMessage.toString() + '}';
	}
}
