package com.saurabh.expensetrackerwalnut.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.saurabh.expensetrackerwalnut.api.TimeUtils.DATE_WITH_YEAR_IN_TWO_DIGIT;

class TimeUtilsTest {
	private final Logger logger = LoggerFactory.getLogger(TimeUtilsTest.class);


	private final String date = "12-02-16";
	private final String time = "01:00 PM";

	@Test
	void testDateAndTime() {
		//GIVEN
		LocalDateTime expectedDateTime = LocalDateTime.of(2016, 2, 12, 13, 0);

		//WHEN
		LocalDateTime actualDateTime = TimeUtils.parseToDateTime(date, time);

		//THEN
		Assertions.assertEquals(actualDateTime, expectedDateTime);
		logger.info(actualDateTime::toString);
	}

	@Test
	void TestDate() {
		//GIVEN
		LocalDate expectedDate = LocalDate.of(2016, 2, 12);

		//WHEN
		LocalDate actualDate = TimeUtils.getLocalDate(date, DATE_WITH_YEAR_IN_TWO_DIGIT);

		//THEN
		Assertions.assertEquals(actualDate, expectedDate);
		logger.info(actualDate::toString);
	}

	@Test
	void TestTime() {
		//GIVEN
		LocalTime expectedTime = LocalTime.of(13, 0);

		//WHEN
		LocalTime actualTime = TimeUtils.getLocalTime(time);

		//THEN
		Assertions.assertEquals(actualTime, expectedTime);
		logger.info(actualTime::toString);
	}

}