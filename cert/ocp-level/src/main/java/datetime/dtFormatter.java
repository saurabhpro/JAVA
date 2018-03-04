package datetime;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class dtFormatter {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2018, Month.JANUARY, 20);
		LocalTime time = LocalTime.of(11, 12, 34);
		LocalDateTime dateTime = LocalDateTime.of(date, time);

		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); //2018-01-20T11:12:34

		System.out.println("\nShort Date :");
		DateTimeFormatter shortDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		//shortDate = DateTimeFormatter.ofPattern("dd-MMMM-yyyy"); // ok

		System.out.println(dateTime.format(shortDate));
		System.out.println(date.format(shortDate)); //20/1/18
		// System.out.println(time.format(shortDate));

		date = LocalDate.of(2018, Month.JANUARY, 20);
		time = LocalTime.of(11, 12, 34);
		dateTime = LocalDateTime.of(date, time);

		System.out.println("\nLocalizedDateTime :");
		DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		DateTimeFormatter longF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		DateTimeFormatter fullF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

		System.out.println(shortF.format(dateTime));
		System.out.println(mediumF.format(dateTime));
		// System.out.println(dateTime.format(mediumF));    // ok
		// System.out.println(longF.format(dateTime));      // DateTimeException exception
		// System.out.println(fullF.format(dateTime));      // exception

		System.out.println("\nZoned");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, ZoneId.systemDefault());
		System.out.println(shortF.format(zonedDateTime));   // 20/1/18 11:12 AM - same as localdatetime
		System.out.println(mediumF.format(zonedDateTime));  // 20 Jan, 2018 11:12:34 AM - same as localdatetime
		System.out.println(longF.format(zonedDateTime));    // 20 January, 2018 11:12:34 AM IST
		System.out.println(fullF.format(zonedDateTime));    // Saturday, 20 January, 2018 11:12:34 AM IST

		System.out.println("\nLocalizedTime:");
		shortF = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		mediumF = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		longF = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
		fullF = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
		System.out.println(shortF.format(time));
		System.out.println(mediumF.format(time));
		// System.out.println(longF.format(time));  // exception
		//System.out.println(fullF.format(time));   // exception

		System.out.println("\nLocalizedDate:");
		shortF = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		mediumF = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		longF = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		fullF = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		System.out.println(shortF.format(date));
		System.out.println(mediumF.format(date));
		System.out.println(longF.format(date));
		System.out.println(fullF.format(date));


		Date old_date = new Date(); // doesnt have zone info - so wrong printed
		DateFormat dfuk = DateFormat.getTimeInstance(DateFormat.LONG, Locale.UK);
		System.out.println("\nUnited Kingdom: " + dfuk.format(old_date));         //  06:20:24 IST

		DateFormat dfcn = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CANADA);
		System.out.println("Canada: " + dfcn.format(old_date));                   //  6:20:24 o'clock AM IST

		// zoned doesnt work
		// System.out.println("\nUnited Kingdom: " + dfuk.format(zonedDateTime));
		// System.out.println("Canada: " + dfcn.format(zonedDateTime));


		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyy, hh:mm");
		System.out.println(dateTime.format(f)); // January 20, 2020, 11:12

		// M outputs 1, MM outputs 01, MMM outputs Jan, and MMMM outputs January.
		// d means 1 digit day , dd means to include the leading zero for a single-digit day.
		// y represents the year. yy outputs a two-digit year and yyy or yyyy outputs a four-digit year.


		System.out.println(zonedDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		String zd1 = "2018-01-20T11:12:34+05:30[Asia/Kolkata]";
		System.out.println(ZonedDateTime.parse(zd1, DateTimeFormatter.ISO_ZONED_DATE_TIME));

				/*
		String d1 = "2016–08–28T05:00 GMT-04:00";
		System.out.println(ZonedDateTime.parse(d1, DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		String d2 = "2016–08–28T09:00 GMT-06:00";
		System.out.println(ZonedDateTime.parse(d2, DateTimeFormatter.ISO_ZONED_DATE_TIME));
                                                      */

	}
}
