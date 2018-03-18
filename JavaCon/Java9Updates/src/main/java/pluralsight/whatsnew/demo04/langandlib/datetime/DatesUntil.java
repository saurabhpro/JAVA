/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.whatsnew.demo04.langandlib.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.stream.Stream;

public class DatesUntil {

	public static void main(String... args) {
		LocalDate start = LocalDate.of(2017, 12, 1);
		Stream<LocalDate> dates = start.datesUntil(start.plusDays(7));
		dates.forEach(System.out::println);


		LocalDate birthday = LocalDate.of(1991, 11, 15);

		long leapYears = birthday
				.datesUntil(LocalDate.now(), Period.ofYears(1))
				.map(d -> Year.of(d.getYear()))
				.filter(Year::isLeap)
				.count();

		System.out.printf("%d leap years since Saurabh was born on %s", leapYears, birthday);
	}
}
