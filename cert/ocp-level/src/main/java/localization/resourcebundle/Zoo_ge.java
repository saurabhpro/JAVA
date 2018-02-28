package localization.resourcebundle;

import java.util.ListResourceBundle;

/**
 * The benefit of having a java resouce file is that here value
 * can be of any type unlike .properties with strings
 */
public class Zoo_ge extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {

		return new Object[][]{
				{"hello", "Hello"},
				{"open", "The zoo is open"}
		};
	}
}