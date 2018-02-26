package datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDatePatterns {
	public static void main(String[] args) {
		// patterns from simple to complex ones
		String[] dateTimeFormats = {
				"dd-MM-yyyy",                   /* d is day (in month), M is month, y is year */
				"d '('E')' MMM, YYYY",          /* E is name of the day like Sat, Sun (in week), Y is year*/
				"w'th week of' YYYY",           /* w is the week of the year */
				"EEEE, dd'th' MMMM, YYYY",      /* EEEE is day name in the week like Saturday, Sunday etc*/
				"D '(Day in year)' Y",          /* D is day in year */
				"W '(Week in Month)' M",        /* W is week in that month */
				"w '(Week in year)' yyy"        /* w is week in that year */
				/* m is minute */
		};


		LocalDateTime now = LocalDateTime.now();
		for (String dateTimeFormat : dateTimeFormats) {
			System.out.printf("Pattern \"%s\" is = %s %n", dateTimeFormat, DateTimeFormatter.ofPattern(dateTimeFormat).format(now));
		}
	}
}

/* Sample Output
Pattern "dd-MM-yyyy" is = 24-12-2017
Pattern "d '('E')' MMM, YYYY" is = 24 (Sun) Dec, 2017
Pattern "w'th week of' YYYY" is = 52th week of 2017
Pattern "EEEE, dd'th' MMMM, YYYY" is = Sunday, 24th December, 2017
Pattern "D '(Day in year)' Y" is = 358 (Day in year) 2017
Pattern "W '(Week in Month)' M" is = 5 (Week in Month) 12
Pattern "w '(Week in year)' yyy" is = 52 (Week in year) 2017
 */