/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package string;

import java.util.stream.Stream;

public class StringFeatures {
	public static void main(String[] args) {
		String st1 = "    ";
		boolean isBlank = st1.isBlank();    // Returns true if the string is empty or contains only white space codepoints, otherwise false.
		System.out.println("'" + st1 + "' is blank: " + isBlank);

		String st2 = "this\nis\r3\r\nlines";
		Stream<String> lines = st2.lines(); //Returns a stream of lines extracted from this string, separated by line terminators.
		lines.forEach(System.out::println);

		String st3 = "neA";
		String repeat = st3.repeat(3);  // Returns a string whose value is the concatenation of this string repeated count times.
		System.out.println(repeat);

		String st4 = "    try       ";
		String strip = st4.strip();     //Returns a string whose value is this string, with all leading and trailing whitespace removed.
		System.out.println("'" + strip + "'");
		System.out.println("with trim tabs are also covered: '"+st4.trim()+"'");

		String stripLeading = st4.stripLeading();       // Returns a string whose value is this string, with all leading whitespace removed.
		System.out.println("'" + stripLeading + "'");

		String stripTrainling = st4.stripTrailing();    // Returns a string whose value is this string, with all trailing whitespace removed.
		System.out.println("'" + stripTrainling + "'");
	}
}
