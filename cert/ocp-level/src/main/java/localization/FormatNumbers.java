package localization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormatNumbers {
	public static void main(String[] args) {
		int attendeesPerYear = 3_200_000;
		int attendeesPerMonth = attendeesPerYear / 12;

		NumberFormat us = NumberFormat.getInstance(Locale.US);
		System.out.println(us.format(attendeesPerMonth));

		NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println(g.format(attendeesPerMonth));

		NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		System.out.println(ca.format(attendeesPerMonth));

		double price = 48;
		NumberFormat in = NumberFormat.getCurrencyInstance();
		in = NumberFormat.getCurrencyInstance(Locale.CHINA);
		System.out.println(in.format(price));

		// Parsing
		NumberFormat nf = NumberFormat.getInstance();   // default
		String one = "456abc";
		String two = "-2.5165x10";
		String three = "x85.3";
		try {
			System.out.println(nf.parse(one)); // 456
			System.out.println(nf.parse(two)); // -2.5165
			System.out.println(nf.parse(three));// throws ParseException
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}


}
