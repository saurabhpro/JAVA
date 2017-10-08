package com.saurabh.entity.attendence;

import com.saurabh.service.helper.utility.constants.enums.AttendanceStatusType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

class AttendanceOfADateTest {

	private AttendanceOfADate attendanceOfADate;

	@Test
	void getAttendanceStatusType() {
		attendanceOfADate = new AttendanceOfADate(LocalDate.of(2017, 10, 6), LocalTime.of(8, 15), LocalTime.of(17, 0), AttendanceStatusType.ABSENT);

		Assertions.assertEquals(AttendanceStatusType.PRESENT, attendanceOfADate.getAttendanceStatusType());

	}

	@Test
	void getWorkTimeForDay() {
		attendanceOfADate = new AttendanceOfADate(LocalDate.now(), LocalTime.of(8, 15), LocalTime.of(17, 0), AttendanceStatusType.PRESENT);

		Assertions.assertEquals(LocalTime.of(8, 45), attendanceOfADate.getWorkTimeForDay());
	}

}