package class_design.enums;

enum Light {}

// public enum Color extends Light { NO

public enum Color implements See {
	RED, BLUE, ORANGE, GREEN;

	//protected Color() {}  // cannot change it's visibility
	private Color() {
	}

	@Override
	public int item() {
		return 0;
	}

	/*other enum methods
	String name() ->
	ordinal() -> 0 based
	*/
}

interface See {
	int item();
}
