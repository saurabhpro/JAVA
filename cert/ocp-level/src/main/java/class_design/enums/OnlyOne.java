package class_design.enums;

public enum OnlyOne {
	ONCE(true),
	THEN(false);

	/*
	Java just returns the already‐constructed enum values.
	So for one enum value constructor is called only once
	 */
	private OnlyOne(boolean b) {
		System.out.println("constructing");
	}

	public static void main(String[] args) {
		OnlyOne firstCall = OnlyOne.ONCE; // prints constructing
		OnlyOne secondCall = OnlyOne.ONCE; // doesn't print anything

		OnlyOne thirdCall = OnlyOne.THEN; // prints constructing    (since different enum value accessed)
	}
}