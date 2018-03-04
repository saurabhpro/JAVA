package localization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class PropertiesBundl {
	public static void main(String[] args) {

		// define a locale
		Locale in = new Locale("en", "IN");

		// make sure to have a properties file in resources folder with name "Zoo_lang" -> Zoo_en for locale "in
		ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo", in);

		// retrieve keys from resource bundle
		Set<String> keys = resourceBundle.keySet();

		keys.stream()
				.map(k -> k + "\t: " + resourceBundle.getString(k))
				.forEach(System.out::println);

		/*
		 * Properties is a really old class that extends Hashtable<Object, Object>
		 */
		// transform resource bundle to Properties
		Properties properties = new Properties();
		keys.stream()
				.map(k -> properties.put(k, resourceBundle.getString(k)));

		System.out.println(properties.getProperty("notReallyAProperty"));
		System.out.println(properties.getProperty("notReallyAProperty", "123"));

		// parameterized resource
		String format = resourceBundle.getString("byName"); // hi, {0}
		String formatted = MessageFormat.format(format, "Saurabh");
		System.out.print(formatted);
	}
}
