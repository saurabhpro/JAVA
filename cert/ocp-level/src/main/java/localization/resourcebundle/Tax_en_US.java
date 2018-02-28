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
		ResourceBundle rb = ResourceBundle.getBundle("localization.resourcebundle.Tax", Locale.US);
		System.out.println(rb.getObject("tax"));

		Locale.setDefault(new Locale("hi"));
		rb = ResourceBundle.getBundle("Zoo", new Locale("en"));
		System.out.println(rb.getBaseBundleName());
	}

	//ResourceBundle.getBundle("name"); ResourceBundle.getBundle("name", locale);
	//The  first one uses the default locale.
	// The exam either tells you what to assume as the default locale or uses the second approach.
}