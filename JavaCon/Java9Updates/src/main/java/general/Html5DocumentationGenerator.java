/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package general;

/**
 * This class is for testing HTML5 Javadoc.
 * <p>
 * Use -html5 to build in html5 else default is still html4
 *
 * @author Saurabh
 * @version 01
 */

public class Html5DocumentationGenerator {

	/**
	 * Run test for input Id.
	 * <p>
	 * Note: input Id should <strong>not</strong> be null.
	 *
	 * @param id the input id to test
	 * @return the String of test result, <strong>"Wrong id!"</strong> if {@code id < 0}
	 * @throws NullPointerException if id is {@code null}
	 * @since 9
	 */

	public static String runTest(Integer id) {

		if (id == null) {
			throw new NullPointerException();
		}
		if (id < 0) {
			return "Wrong id!";
		}

		return "Run Test for id: " + id;
	}
}
