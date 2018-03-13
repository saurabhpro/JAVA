package localization.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class FallBack {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		ResourceBundle rb = ResourceBundle.getBundle("Cars", new Locale("fr", "FR"));

		System.out.println(rb.getString("country") + " " + rb.getString("engine"));


		/*
		 * “It is in the English properties file,
		 * but Java cannot look at the default locale if it found a match with the requested locale.”
		 */
		rb = ResourceBundle.getBundle("Cars", new Locale("fr", "CA"));
		System.out.println(rb.getString("engine") + " " + rb.getString("horses"));
	}
}
