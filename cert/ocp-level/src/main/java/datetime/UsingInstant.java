package datetime;

import java.time.*;

public class UsingInstant {
	public static void main(String args[]) {

		// prints the current timestamp with UTC as time zone
		Instant currTimeStamp = Instant.now();
		System.out.println("Instant timestamp is: " + currTimeStamp);

		// LocalDateTime is: 2017-12-20T20:53:01.114 	Instant is: 2017-12-20T15:23:01.114Z
		LocalDateTime localDateTime = LocalDateTime.now();
		Instant instant = Instant.now();
		System.out.println("LocalDateTime is: " + localDateTime + " \tInstant is: " + instant);


		// prints the number of seconds as Unix timestamp from epoch time
		System.out.println("Number of seconds elapsed: " + currTimeStamp.getEpochSecond());

		// prints the Unix timestamp in milliseconds
		System.out.println("Number of milliseconds elapsed: " + currTimeStamp.toEpochMilli());


		LocalDateTime comingMidnight = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT);
		LocalDateTime now = LocalDateTime.now();

		Duration between = Duration.between(now, comingMidnight);
		System.out.println(between);

		// Without a time zone, Java doesn’t know what moment in time to use for the Instant.
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
		long epochSeconds = 0;
		//Instant instant =   dateTime.toInstant;

	}
}

