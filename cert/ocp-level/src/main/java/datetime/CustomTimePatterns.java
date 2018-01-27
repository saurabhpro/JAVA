package datetime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// Using examples, illustrates how to use "pattern strings" for creating basics time formats
class CustomTimePatterns {
	public static void main(String[] args) {
		// patterns from simple to complex ones
		String[] timeFormats = {
				"h:mm",          /* h is hour in am/pm (1-12), m is minute */
				"hh 'o''clock'", /* '' is the escape sequence to print a single quote */
				"H:mm a",
				"hh:mm:ss.SSS",
				"K:mm:ss a"
				/* H is hour in day (0-23),
				/* a is am/pm
				/* s is seconds, S is milliseconds */
				/* K is hour in am/pm(0-11) */
		};

		LocalTime now = LocalTime.now();

		now = LocalTime.MIDNIGHT.plusMinutes(44);
		for (String timeFormat : timeFormats) {
			System.out.printf("Time in pattern \"%s\" is %s %n", timeFormat, DateTimeFormatter.ofPattern(timeFormat).format(now));
		}
	}
}

/*
Time in pattern "h:mm" is 12:44
Time in pattern "hh 'o''clock'" is 12 o'clock
Time in pattern "H:mm a" is 0:44 AM
Time in pattern "hh:mm:ss.SSS" is 12:44:00.000
Time in pattern "K:mm:ss a" is 0:44:00 AM
 */