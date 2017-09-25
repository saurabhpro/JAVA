/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestPatternMatcher {
	private static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\w+");
		// in case you would like to ignore case sensitivity,
		// you could use this statement:
		// Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);

		Matcher matcher = pattern.matcher(EXAMPLE_TEST);

		// check all occurrence
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
		}

		// now create a new pattern and matcher to replace whitespace with tabs
		Pattern replace = Pattern.compile("\\s+");
		Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
		System.out.println(matcher2.replaceAll("\t"));
	}
}