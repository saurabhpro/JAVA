package localization.resourcebundle;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class CountResource extends ListResourceBundle {
	private int count = 0;

	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("localization.resourcebundle.CountResource");
		System.out.println(rb.getObject("count") + " " + rb.getObject("count"));

		System.out.println(rb.getObject("nextCount"));
	}

	@Override
	// protected abstract method in base class
	protected Object[][] getContents() {
		// defined when loaded so count = 0 for rest of eternity
		return new Object[][]{
				{"count", count++},
				{"nextCount", count}
		};
	}
}