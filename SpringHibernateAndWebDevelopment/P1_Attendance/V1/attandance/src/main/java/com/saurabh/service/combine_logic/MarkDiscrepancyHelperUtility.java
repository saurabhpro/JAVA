package com.saurabh.service.combine_logic;

import com.saurabh.entity.attendence.AttendanceOfLeave;
import com.saurabh.service.helper.utility.constants.ProjectConstants;
import com.saurabh.service.helper.utility.constants.enums.AttendanceStatusType;
import com.saurabh.service.helper.utility.constants.enums.LeaveType;
import com.saurabh.viewmodel.FinalObjectModel;

import java.time.LocalDate;

/**
 * Created by Saurabh on 4/10/2016.
 *
 * @author Amrita & Saurabh
 * @version 1.6 Helper Utility class for MarkDiscrepancy
 * @since 1.5 loop till getNumberOfDaysConsideredInRespectiveMonth()
 */
final class MarkDiscrepancyHelperUtility {

	private MarkDiscrepancyHelperUtility() {
	}

	/**
	 * Method to set clarification needed to true if no leaves are applied for
	 * any absent day
	 *
	 * @param finalObjectModel Object modal for Final Object that contains
	 *                         result of combining Biometric and Financial Force
	 */
	static void checkAbsentButNoLeaveApplied(FinalObjectModel finalObjectModel) {
		for (int j = 0; j < ProjectConstants.getNumberOfDaysConsideredInRespectiveMonth(); j++) {
			if (isUnaccountedOrHalfDay(finalObjectModel.attendanceOfADate[j].getAttendanceStatusType())) {
				finalObjectModel.setIfClarificationNeeded(true);
				break;  //why loop when clarification already set
			}
		}
	}

	private static boolean isUnaccountedOrHalfDay(AttendanceStatusType attendanceStatusType) {
		return attendanceStatusType.equals(AttendanceStatusType.UNACCOUNTED_ABSENCE)
				|| attendanceStatusType.equals(AttendanceStatusType.HALF_DAY);
	}

	/**
	 * Method to set clarification needed to true if employee has entries in
	 * both files for a day
	 *
	 * @param finalObjectModel Object modal for Final Object that contains
	 *                         result of combining Biometric and Financial Force
	 */
	static void checkIfEntryPresentInBothBiometricAndSalesForce(FinalObjectModel finalObjectModel) {
		int flag;
		for (int day = 0; day < ProjectConstants.getNumberOfDaysConsideredInRespectiveMonth(); day++) {
			flag = 0;
			// his status is still absent after merging
			if (finalObjectModel.attendanceOfADate[day].getAttendanceStatusType() == AttendanceStatusType.UNACCOUNTED_ABSENCE) {

				int[] temp;
				for (AttendanceOfLeave leave : finalObjectModel.attendanceOfLeaves) {
					temp = setClarificationStatus(day, finalObjectModel, leave, DiscrepancyCause.AbsentInOneNotInOther);
					day = temp[0];
					flag = temp[1];

					if (flag == 1)
						break;
				}
				if (flag == 0) {
					finalObjectModel.setIfClarificationNeeded(true);
				}
			}

			// MarkDiscrepancy if there is an entry for an employeemodal in both
			// Biometric and Hrnet file.
			else if (finalObjectModel.attendanceOfADate[day].getAttendanceStatusType() == AttendanceStatusType.PRESENT) {
				for (AttendanceOfLeave leave : finalObjectModel.attendanceOfLeaves) {
					setClarificationStatus(day, finalObjectModel, leave, DiscrepancyCause.PresentInBoth);
				}
			}

			// MarkDiscrepancy if an employeemodal applies for half day but
			// works
			// for less than four hours.
			else if (finalObjectModel.attendanceOfADate[day].getAttendanceStatusType() == AttendanceStatusType.HALF_DAY) {
				setIfHalfDayLessThanFourHoursWork(finalObjectModel, day);
			}
		}
	}

	private static void setIfHalfDayLessThanFourHoursWork(FinalObjectModel f, int j) {
		// Half day worked but no leave applied
		if (f.attendanceOfADate[j].getLeaveTypeForThisDate() == LeaveType.NO_LEAVE)
			f.setIfClarificationNeeded(true);
		else {
			for (AttendanceOfLeave leave : f.attendanceOfLeaves) {
				if (leave.getStartDate().getDayOfMonth() == j + 1) {
					if ((f.attendanceOfADate[j].getWorkTimeForDay() == null) || (f.attendanceOfADate[j].getWorkTimeForDay().getHour() < 4)) {
						f.setIfClarificationNeeded(true);
					}
				}
			}
		}
	}

	private static int[] setClarificationStatus(int day, FinalObjectModel finalObjectModel, AttendanceOfLeave leave, DiscrepancyCause type) {
		int flag = 0;
		LocalDate startDate = leave.getStartDate();
		LocalDate endDate = leave.getEndDate();

		int beginHoliday = startDate.getDayOfMonth();

		if (beginHoliday == (day + 1)) {
			flag = 1;

			while (startDate.compareTo(endDate) <= 0) {
				switch (type) {
					case AbsentInOneNotInOther:
						day++;
						break;
					/* case not considered coz if status is present from biometric,
					we never check hrnet details and update the leave status, hence*/
					case PresentInBoth:
						if (leave.getLeaveType() != LeaveType.WORK_FROM_HOME_IND) {
							// System.out.println("MarkDiscrepancy set for present:
							// " + finalObjectModel.getName() + " Date:" + (j + 1));
							finalObjectModel.setIfClarificationNeeded(true);
						}
				}

				if (finalObjectModel.getIfClarificationNeeded())
					break;

				startDate = startDate.plusDays(1);
			}
		}
		return new int[]{day, flag};
	}

	private enum DiscrepancyCause {
		AbsentInOneNotInOther,
		PresentInBoth
	}

}
