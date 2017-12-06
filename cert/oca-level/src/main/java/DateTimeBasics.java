import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class DateTimeBasics {
	public static void main(String[] args) {
		LocalDate date2 = LocalDate.of(2015, Month.JANUARY, 20);

		Period wrong = Period.ofYears(1).ofWeeks(1); // every week
		// This tricky code is really like writing the following:

		// Period wrong = Period.ofYears(1);
		// wrong = Period.ofWeeks(7);
	}

	public static void main(Object[] args) {
		LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
		LocalDate dt = LocalDate.now();
		performAnimalEnrichment(start, end);

		Period period = Period.ofMonths(1); // create a period
		performAnimalEnrichment(start, end, period);
	}

	private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
		LocalDate upTo = start;
		while (upTo.isBefore(end)) { // check if still before end
			System.out.println("give new toy: " + upTo);
			upTo = upTo.plusMonths(1); // add a month }}
		}
	}

	/*
	The method can add an arbitrary period of time that gets passed in.
	This allows us to reuse the same method for different periods of time as our zookeeper changes her mind.

	Period annually = Period.ofYears(1); // every 1 year
	Period quarterly = Period.ofMonths(3); // every 3 months
	Period everyYearAndAWeek = Period.of(1, 0, 7);// every year and 7 days
	 */
	private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) { // uses the generic period
		LocalDate upTo = start;
		while (upTo.isBefore(end)) {
			System.out.println("give new toy: " + upTo);
			upTo = upTo.plus(period); // adds the period
		}
	}


}