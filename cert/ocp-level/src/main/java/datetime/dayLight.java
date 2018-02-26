package datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Starting in 2007, DST begins in the United States on the second Sunday in March,
 * when people move their clocks forward an hour at 2 a.m. local standard time
 * (so at 2 a.m. on that day, the clocks will then read 3 a.m. local daylight time).
 * <p>
 * Daylight saving time ends on the first Sunday in November, when clocks are moved
 * back an hour at 2 a.m. local daylight time (so they will then read 1 a.m. local standard time).
 * <p>
 * Last year, DST began on March 12 and ended on Nov. 5.
 * And this year, DST begins on March 11 and ends on Nov. 4, 2018.
 * You will then move your clock forward an hour on March 11, 2018, and the cycle will begin again.
 */
public class dayLight {
	public static void main(String[] args) {

		LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
		LocalTime time = LocalTime.of(1, 30);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
		System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]

		dateTime = dateTime.plusHours(1);
		System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]


		date = LocalDate.of(2016, Month.MARCH, 13);
		time = LocalTime.of(2, 30);
		zone = ZoneId.of("US/Eastern");
		dateTime = ZonedDateTime.of(date, time, zone);
		System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]


		date = LocalDate.of(2016, Month.NOVEMBER, 6);
		time = LocalTime.of(1, 30);
		zone = ZoneId.of("US/Eastern");
		dateTime = ZonedDateTime.of(date, time, zone);
		System.out.println(dateTime); // 2016–11–06T01:30–04:00[US/Eastern]

		dateTime = dateTime.plusHours(1);
		System.out.println(dateTime); // 2016–11–06T01:30–05:00[US/Eastern]

		dateTime = dateTime.plusHours(1);
		System.out.println(dateTime); // 2016–11–06T02:30–05:00[US/Eastern]

		ques();

		ques2();

		ques3();
	}

	private static void ques3() {
		String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
		String m2 = Duration.ofMinutes(1).toString();
		String s = Duration.of(60, ChronoUnit.SECONDS).toString();
		String d = Duration.ofDays(1).toString();
		String p = Period.ofDays(1).toString();

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(s);
		System.out.println(d);
		System.out.println(p);
	}

	private static void ques2() {
		ZoneId zone = ZoneId.of("US/Eastern");
		LocalDate date = LocalDate.of(2016, 3, 13);
		//LocalDate date = LocalDate.of(2016, 11, 6) ;
		//LocalDate date = LocalDate.of(2016, 11, 7);
		LocalTime time1 = LocalTime.of(2, 15);
		ZonedDateTime a = ZonedDateTime.of(date, time1, zone);
		System.out.println(a);
	}

	private static void ques() {
		LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
		LocalTime time = LocalTime.of(1, 30);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime1 = ZonedDateTime.of(date, time, zone);
		ZonedDateTime dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);
		long hours = ChronoUnit.HOURS.between(dateTime1, dateTime2);
		int clock1 = dateTime1.getHour();
		int clock2 = dateTime2.getHour();
		System.out.println(hours + "," + clock1 + "," + clock2);
	}
}
