/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special_classes;

import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Date;

public class MessageFormatter {

	public static void main(String args[]) {

		String text = MessageFormat.format("You''re about to see {0} rows.", 5);
		System.out.println(text);
		// You're about to see 5 rows.

		formattingExamplesWithMoreArguments();

		useMessageConstructor();

		moreFormat();
	}

	private static void formattingExamplesWithMoreArguments() {
		int planet = 7;
		String event = "a disturbance in the Force";
		String pattern = "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.";

		String result = MessageFormat.format(pattern, planet, new Date(), event);

		System.out.println(result);
	}

	public static void useMessageConstructor() {
		// using ChoiceFormat time and number below
		String pattern = "The time is {0,time} and ";
		pattern += "your number is {1,number}.";

		Object objects[] = {new Date(), (Math.random() * 1000)};

		MessageFormat formatter = new MessageFormat(pattern);
		String formattedOutput = formatter.format(objects);

		System.out.println(formattedOutput);
		// The time is 9:44:45 PM and your number is 832.395.
	}

	private static void moreFormat() {
		MessageFormat mf = new MessageFormat("{0,number,#.##}, {0,number,#.#}");
		Object[] objs = {3.1415};

		String result = mf.format(objs);
		System.out.println(result);
		// result now equals "3.14, 3.1"

		objs = null;
		objs = mf.parse(result, new ParsePosition(0));
		System.out.println(Arrays.toString(objs));  // [3.1]
		// objs now equals {new Double(3.1)}
	}
}
