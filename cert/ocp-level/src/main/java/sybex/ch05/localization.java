package sybex.ch05;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class localization {
	public static void main(String[] args) {

		Locale current = Locale.getDefault();
		System.out.println(current);

		Locale forEnglish = Locale.forLanguageTag("EN");
		System.out.println(forEnglish);

		Locale[] all = Locale.getAvailableLocales();
		Arrays.stream(all).forEach(System.out::println);

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

		System.out.println(Locale.getDefault()); // en_IN
		Locale locale = new Locale("fr");
		Locale.setDefault(locale); // change the default
		System.out.println(Locale.getDefault()); // fr

		/* RESOURCE BUNDLE
		Zoo_en.properties
				hello=Hello
				open=The zoo is open.

		Zoo_fr.properties
				hello=Bonjour
				open=Le zoo est ouvert
		 */

		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("open"));
	}
}
