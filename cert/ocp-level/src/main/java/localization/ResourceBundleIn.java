package localization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class ResourceBundleIn {
	public static void main(String[] args) {

		System.out.println("\ndefault locale: " + Locale.getDefault()); // en_IN
		Locale locale = new Locale("fr");
		Locale.setDefault(locale); // change the default
		System.out.println("changed locale: " + Locale.getDefault()); // fr

		/* RESOURCE BUNDLE
		Zoo_en.properties
				hello=Hello
				open=The zoo is open.

		Zoo_fr.properties
				hello=Bonjour
				open=Le zoo est ouvert
		 */

		System.out.println("\nResourceBundle");
		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
		System.out.println(rb.getBaseBundleName() + " " + rb.getString("hello"));
		System.out.println(rb.getString("open"));

		System.out.println();
		final Enumeration<String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			System.out.println(keys.nextElement());
		}
		// final String[] opens = rb.getStringArray("open");
		// Arrays.stream(opens).map(k -> k + " ").forEach(System.out::print);
		System.out.println();
		final Set<String> strings = rb.keySet();
		final Object open = rb.getObject("open");
	}
}
