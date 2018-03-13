package datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Until {
	public static void main(String[] args) {
		Instant currTimeStamp = Instant.now();
		System.out.println("Instant1 is: " + currTimeStamp);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant instant = Instant.now();
		System.out.println(" \tInstant2 is: " + instant);


		final Instant instant1 = currTimeStamp.truncatedTo(ChronoUnit.MINUTES);
		final Instant instant2 = instant.truncatedTo(ChronoUnit.MINUTES);

		if (instant1.isAfter(instant2)) {
			System.out.println("after");
		} else {
			System.out.println(instant1 + "\n" + instant2);
			System.out.println("before");
		}

		LocalDateTime dateTime1 = LocalDateTime.of(2018, 12, 25, 11, 0);
		LocalDateTime dateTime2 = dateTime1.minus(Period.ofMonths(1));
		final long until = dateTime2.until(dateTime1, ChronoUnit.DAYS);
		System.out.println(until);
	}
}
