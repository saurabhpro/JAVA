/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package exceptions;//: exceptions/MainException.java

import java.io.FileInputStream;
import java.io.IOException;

public class MainException {
	// Pass all exceptions to the console:
	public static void main(String[] args) throws AssertionError, IOException {
		// Open the file:
		FileInputStream file =
				new FileInputStream("MainException.java");
		// Use the file ...
		// Close the file:
		file.close();

	}
} ///:~
