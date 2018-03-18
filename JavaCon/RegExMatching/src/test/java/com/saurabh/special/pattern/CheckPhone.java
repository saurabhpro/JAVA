/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckPhone {

	@Test
	void testSimpleTrue() {
		String pattern = "\\d\\d\\d([,\\s])?\\d\\d\\d\\d";

		String s = "1233323322";
		assertFalse(s.matches(pattern));

		s = "1233323";
		assertTrue(s.matches(pattern));

		s = "123 3323";
		assertTrue(s.matches(pattern));
	}
}