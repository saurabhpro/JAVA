package class_design.enums;

public enum Season {
	WINTER("Low"),
	SPRING("Medium"),
	SUMMER("High"),
	FALL("Medium");    // the semicolon at the end of the enum values is optional only if the only thing in the enum is that list of values.

	private String expectedVisitors;

	// any constructor in enum is already private
	private Season(String expectedVisitors) {
		this.expectedVisitors = expectedVisitors;
	}

	// it's ok
	public static void main(String[] args) {
		Season.SUMMER.printExpectedVisitors();
	}

	public void printExpectedVisitors() {
		System.out.println(expectedVisitors);
	}
}

/*class Test {
	public static void main(String[] args) {
		Season.SUMMER.printExpectedVisitors();
	}
}*/