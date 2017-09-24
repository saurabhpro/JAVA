package Ch16_Moderate.Q16_12_XML_Encoding;

import java.util.ArrayList;

@SuppressWarnings("Duplicates")
class Element {
	public final ArrayList<Attribute> attributes;
	public final ArrayList<Element> children;
	private final String name;
	public String value;

	public Element(String n) {
		name = n;
		attributes = new ArrayList<>();
		children = new ArrayList<>();
	}

	public Element(String n, String v) {
		name = n;
		value = v;
		attributes = new ArrayList<>();
		children = new ArrayList<>();
	}

	public String getNameCode() {
		if (name == "family") {
			return "1";
		} else if (name == "person") {
			return "2";
		} else if (name == "firstName") {
			return "3";
		} else if (name == "lastName") {
			return "4";
		} else if (name == "state") {
			return "5";
		}
		return "--";
	}

	public void insert(Attribute attribute) {
		attributes.add(attribute);
	}

	public void insert(Element child) {
		children.add(child);
	}
}
