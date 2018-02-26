package datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

public class TimeDifference {
	public static void main(String[] args) {
		ZoneId singaporeZone = ZoneId.of("Asia/Singapore");
		ZonedDateTime dateTimeInSingapore = ZonedDateTime.of(LocalDateTime.of(2016, Month.JANUARY, 1, 6, 0), singaporeZone);

		ZoneId aucklandZone = ZoneId.of("Pacific/Auckland");
		ZonedDateTime sameDateTimeInAuckland = dateTimeInSingapore.withZoneSameInstant(aucklandZone);

		Duration timeDifference = Duration.between(dateTimeInSingapore.toLocalTime(), sameDateTimeInAuckland.toLocalTime());

		System.out.printf("Time difference between %s and %s zones is %d hours", singaporeZone, aucklandZone, timeDifference.toHours());

		ZoneId kolkataZone = ZoneId.of("Asia/Kolkata");
		Duration kolkataDST = kolkataZone.getRules().getDaylightSavings(Instant.now());
		System.out.printf("\nKolkata zone DST is: %d hours %n", kolkataDST.toHours());


		Duration aucklandDST = aucklandZone.getRules().getDaylightSavings(Instant.now());
		System.out.printf("Auckland zone DST is: %d hours", aucklandDST.toHours());

		LocalTime wakeupTime = LocalTime.of(6, 0, 0);
		System.out.println("Wake up time: " + DateTimeFormatter.ISO_TIME.format(wakeupTime));


		Period pr = Period.of(66, 12, 77);
		System.out.println(pr);


		System.out.println(Period.ofWeeks(3)); //P21D

		// A Duration is stored in hours, minutes, and seconds.
		// The number of seconds includes fractional seconds.
		/*
		Duration daily = Duration.ofDays(1);// PT24H
		Duration hourly = Duration.ofHours(1);// PT1H
		Duration everyMinute = Duration.ofMinutes(1);// PT1M
		Duration everyTenSeconds = Duration.ofSeconds(10);// PT10S
		System.out.println(Duration.ofSeconds(3600));// PT1H - it converts
		Duration everyMilli = Duration.ofMillis(1);// PT0.001S
		Duration everyNano = Duration.ofNanos(1);// PT0.000000001S
		*/

		// The previous example could be rewritten as this:
		Duration daily = Duration.of(1, ChronoUnit.DAYS);
		Duration hourly = Duration.of(1, ChronoUnit.HOURS);
		Duration everyMinute = Duration.of(1, ChronoUnit.MINUTES);
		Duration everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
		Duration everyMilli = Duration.of(1, ChronoUnit.MILLIS);
		Duration everyNano = Duration.of(1, ChronoUnit.NANOS);


		Duration everyHalfDay = Duration.of(1, ChronoUnit.HALF_DAYS);
		System.out.println(everyHalfDay); //PT12H

		LocalTime one = LocalTime.of(5, 15);
		LocalTime two = LocalTime.of(6, 30);
		LocalDate date = LocalDate.of(2016, 1, 20);

		System.out.println(ChronoUnit.HOURS.between(one, two)); // 1
		System.out.println(ChronoUnit.MINUTES.between(one, two)); // 75

		//System.out.println(ChronoUnit.HOURS.between(one, date));
		// java.time.DateTimeException: Unable to obtain LocalTime from TemporalAccessor: 2016-01-20 of type java.time.LocalDate
		// java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Hours

		Instant now = Instant.now();
		// do something time consuming
		int sum = IntStream.iterate(0, (a) -> a++).limit(100).sum();
		System.out.println(sum);
		Instant later = Instant.now();
		Duration duration = Duration.between(now, later);
		System.out.println(duration.toNanos());
	}
}
