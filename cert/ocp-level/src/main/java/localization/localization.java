package localization;

import java.util.Arrays;
import java.util.Locale;

public class localization {
	public static void main(String[] args) {

		Locale current = Locale.getDefault();
		System.out.println(current);

		Locale forEnglish = Locale.forLanguageTag("en");
		System.out.println(forEnglish);

		Locale[] all = Locale.getAvailableLocales();
		Arrays.stream(all)
				.limit(5)
				.forEach(System.out::println);


		/* INVALID
		US      // can have a language without a country, but not the reverse
		enUS    // missing underscore
		US_en   // the country and language are reversed
		EN      // language must be lowercase
		 */

		Locale l1 = new Locale.Builder()
				.setLanguage("en")
				.setRegion("US")
				.build();


		Locale l2 = new Locale.Builder()
				.setLanguage("RETre")   // no checks here
				.setRegion("dr")    // IllformedLocaleException is thrown if this ir > 2 characters (will be toUpperCased'd)
				.build();

		System.out.println("This is legal but useless: " + l2);
		/*
		 * So basically what we have seen is - be cautious
		 */

		System.out.println("\ndefault locale: " + Locale.getDefault()); // en_IN
		Locale locale = new Locale("fr");
		Locale.setDefault(locale); // change the default
		System.out.println("changed locale: " + Locale.getDefault()); // fr


		Locale.setDefault(Locale.KOREAN);
		System.out.println(Locale.getDefault());
		Locale.setDefault(new Locale("en", "AU"));
		System.out.println(Locale.getDefault());
		Locale.setDefault(new Locale("EN"));
		System.out.println(Locale.getDefault());
	}
}
