package localization.resourcebundle;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class Type extends ListResourceBundle {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("localization.resourcebundle.Type");
		List<String> keys = (List) rb.getObject("keys");
		keys.add("q");
		keys.add("w");
		keys.add("e");
		keys.add("r");
		keys.add("t");
		keys.add("y");
		System.out.println(((List) rb.getObject("keys")).size());
	}

	protected Object[][] getContents() {
		return new Object[][]{{"keys", new ArrayList<String>()}};
	}
}