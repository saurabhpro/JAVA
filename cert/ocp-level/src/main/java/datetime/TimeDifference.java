package datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

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

		Period.of(66, 12, 77);

	}
}
