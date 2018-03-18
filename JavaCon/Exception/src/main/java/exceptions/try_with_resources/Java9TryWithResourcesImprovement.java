/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package exceptions.try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("JavaDoc")
class Java9TryWithResourcesImprovement {
	/**
	 * Here we have created an utility method which creates a BufferedReader object to read the content of a file.
	 * If we observe the above code snippet, even though we have reader1 referring to BufferedReader object,
	 * we should create a duplicate one “reader2” to use it in Try-With-Resources.
	 * <p>
	 * It is one small bug or issue in Java SE 7 or 8 versions.
	 * <p>
	 * We cannot use any Resource (which is declared outside the Try-With-Resources) within try() block of Try-With-Resources statement.
	 * <p>
	 *
	 * @throws IOException
	 */
	void testARM_Java8() throws IOException {
		//noinspection UnnecessaryLocalVariable
		BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
		try (BufferedReader reader2 = reader1) {
			System.out.println(reader2.readLine());
		}
	}

	/**
	 * Below code is invalid in Java SE 7 or 8 versions. It throws compile-time error.
	 *
	 * @throws IOException
	 */
	void testARM_Java9() throws IOException {
		BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
		try (reader1) {
			System.out.println(reader1.readLine());
		}
	}
}
