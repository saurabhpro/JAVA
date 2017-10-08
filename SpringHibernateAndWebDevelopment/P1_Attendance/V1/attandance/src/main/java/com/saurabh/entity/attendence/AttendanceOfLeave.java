package com.saurabh.entity.attendence;

import com.saurabh.service.helper.utility.constants.enums.LeaveType;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by kumars on 2/12/2016.
 */
@Component
public class AttendanceOfLeave implements Serializable, Attendance {

	private LeaveType leaveType = null;
	private LocalDate startDate = null;
	private LocalDate endDate = null;
	private double absenceTime;

	public double getAbsenceTime() {
		return absenceTime;
	}

	public void setAbsenceTime(double absenceTime) {
		this.absenceTime = absenceTime;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "AttendanceOfLeave{" +
				"leaveType=" + leaveType +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", absenceTime=" + absenceTime +
				'}';
	}
}
