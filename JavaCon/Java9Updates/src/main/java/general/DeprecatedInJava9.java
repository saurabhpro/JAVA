/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package general;

@SuppressWarnings("DeprecatedIsStillUsed")
class DeprecatedInJava9 {

	public static void main(String[] args) {
		DeprecatedInJava9 inJava9 = new DeprecatedInJava9();
		inJava9.thisIsGone();
	}

	/**
	 * @deprecated this is a test for deprecation
	 */
	@Deprecated(since = "1.2", forRemoval = true)
	void thisIsGone() {
	}
}
