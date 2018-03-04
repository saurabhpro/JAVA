package localization.resourcebundle;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * the class name specifies both the language code and country code.
 */
public class Tax_en_US extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][]{{"tax", new UsTaxCode()}};
	}
}

class UsTaxCode {
	@Override
	public String toString() {
		return "tax free system";
	}
}

class Runner {
	public static void main(String[] args) {
		System.out.println(Locale.getDefault());
		ResourceBundle rb = ResourceBundle.getBundle("localization.resourcebundle.Tax", Locale.US);
		System.out.println(rb.getObject("tax"));

		Locale.setDefault(new Locale("hi"));
		rb = ResourceBundle.getBundle("Zoo", new Locale("en"));
		/*
		 * Since we havn't specified the country java will look in sex files to check for correct one
		 * 1. Zoo_hi.java
		 * 2. Zoo_hi.properties
		 * 3. Zoo_en.java
		 * 4. Zoo_en.properties
		 * 5. Zoo.java
		 * 6. Zoo.properties
		 */
		System.out.println(rb.getBaseBundleName());
	}

	// ResourceBundle.getBundle("name");  	//This one uses the default locale.
	// ResourceBundle.getBundle("name", locale);
	// The exam either tells you what to assume as the default locale or uses the second approach.
}