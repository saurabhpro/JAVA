package com.saurabh.expensetrackerwalnut.api;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public interface TimeUtils {

	String TIME_IN_12_HOURS_FORMAT = "hh:mm a";
	String DATE_WITH_YEAR_IN_TWO_DIGIT = "dd-MM-yy";
	String DATE_WITH_YEAR_IN_FOUR_DIGIT = "dd-MM-yyyy";

	static LocalDateTime parseToDateTime(String date, String timeIn12HoursFormat) {
		return LocalDateTime.of(getLocalDate(date, DATE_WITH_YEAR_IN_TWO_DIGIT), getLocalTime(timeIn12HoursFormat));
	}

	static LocalTime getLocalTime(String timeIn12HoursFormat) {
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_IN_12_HOURS_FORMAT);
		return LocalTime.parse(timeIn12HoursFormat, timeFormatter);
	}

	static LocalDate getLocalDate(String date, String pattern) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

		//default, ISO_LOCAL_DATE = 2016-15-11
		return LocalDate.parse(date, dateFormatter);
	}
}
