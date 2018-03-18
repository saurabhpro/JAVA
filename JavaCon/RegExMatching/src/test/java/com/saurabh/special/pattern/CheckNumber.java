/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.pattern;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckNumber {

	private static boolean test(String s) {
		Pattern pattern = Pattern.compile("\\d{3}");
		Matcher matcher = pattern.matcher(s);

		return matcher.find();
	}

	@Test
	void testSimpleTrue() {
		String s = "1233";
		assertTrue(test(s));

		s = "0";
		assertFalse(test(s));

		s = "29 Kasdkf 2300 Kdsdf";
		assertTrue(test(s));

		s = "99900234";
		assertTrue(test(s));
	}

}