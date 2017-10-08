package com.saurabh.entity.attendence;

import com.saurabh.service.helper.utility.TimeManager;
import com.saurabh.service.helper.utility.constants.enums.AttendanceStatusType;
import com.saurabh.service.helper.utility.constants.enums.LeaveType;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.saurabh.service.helper.utility.constants.ProjectConstants.MIN_WORK_HOURS_FOR_FULL_DAY;
import static com.saurabh.service.helper.utility.constants.ProjectConstants.WORK_HOURS_FOR_HALF_DAY;

/**
 * Created by kumars on 2/12/2016.
 *
 * @author Saurabh
 * @version 1.3
 */

@Component
public class AttendanceOfADate implements Serializable, Attendance {
	private LocalDate currentDate;
	private LocalTime checkIn;
	private LocalTime checkOut;
	private LocalTime overTime;
	private LocalTime workTimeForDay;
	private AttendanceStatusType attendanceStatusType;
	private LeaveType leaveTypeForThisDate = LeaveType.NO_LEAVE;


	private AttendanceOfADate() {
	}

	public AttendanceOfADate(LocalDate currentDate, LocalTime checkIn, LocalTime checkOut, AttendanceStatusType attendanceStatus) {
		this.currentDate = currentDate;
		this.checkIn = checkIn;
		this.checkOut = checkOut;

		// handle these cases
		this.setWorkTimeForDay(null);
		this.setAttendanceStatusType(attendanceStatus);
	}

	public LocalTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalTime checkIn) {
		this.checkIn = checkIn;
	}

	public LocalTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalTime checkOut) {
		this.checkOut = checkOut;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public LocalTime getOverTime() {
		return overTime;
	}

	public void setOverTime(LocalTime overTime) {
		this.overTime = overTime;
	}

	public LeaveType getLeaveTypeForThisDate() {
		return leaveTypeForThisDate;
	}

	public void setLeaveTypeForThisDate(LeaveType leaveTypeForThisDate) {
		this.leaveTypeForThisDate = leaveTypeForThisDate;
	}

	public LocalTime getWorkTimeForDay() {
		return workTimeForDay;
	}

	public void setWorkTimeForDay(LocalTime workTimeForDay) {
		if (workTimeForDay == null && getCheckIn() != null && getCheckOut() != null && getCurrentDate() != null)
			workTimeForDay = TimeManager.calculateTimeDifference(getCheckIn(), getCheckOut(), getCurrentDate());

		this.workTimeForDay = workTimeForDay;
	}

	public AttendanceStatusType getAttendanceStatusType() {
		return attendanceStatusType;
	}

	public void setAttendanceStatusType(AttendanceStatusType statusType) {
		//by default set sat and sunday to weekend
		if (getCurrentDate().getDayOfWeek() == DayOfWeek.SATURDAY
				|| getCurrentDate().getDayOfWeek() == DayOfWeek.SUNDAY)
			statusType = AttendanceStatusType.WEEKEND_HOLIDAY;

		if (statusType == AttendanceStatusType.ABSENT) {
			if (getWorkTimeForDay() != null && !getCheckOut().equals(LocalTime.MIDNIGHT)) {
				statusType = AttendanceStatusType.PRESENT;
			}
		}

		if (statusType.compareTo(AttendanceStatusType.PRESENT) == 0) {
			if (getWorkTimeForDay() == null || getWorkTimeForDay().compareTo(WORK_HOURS_FOR_HALF_DAY) < 0)
				statusType = AttendanceStatusType.ABSENT;
			else if (getWorkTimeForDay().compareTo(MIN_WORK_HOURS_FOR_FULL_DAY) < 0)
				statusType = AttendanceStatusType.HALF_DAY; // first point where
			// we set HALF_DAY
		}

		this.attendanceStatusType = statusType;
	}

	@Override
	public String toString() {
		return "AttendanceOfADate{" +
				"currentDate=" + currentDate +
				", checkIn=" + checkIn +
				", checkOut=" + checkOut +
				", overTime=" + overTime +
				", workTimeForDay=" + workTimeForDay +
				", attendanceStatusType=" + attendanceStatusType +
				", leaveTypeForThisDate=" + leaveTypeForThisDate +
				'}';
	}
}
