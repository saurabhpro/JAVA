/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EitherOrCheck {
	@Test
	void testSimpleTrue() {
		String s = "humbapumpa jim";
		assertTrue(s.matches(".*(jim|joe).*"));

		s = "humbapumpa jom";
		assertFalse(s.matches(".*(jim|joe).*"));

		s = "humbaPumpa joe";
		assertTrue(s.matches(".*(jim|joe).*"));

		s = "humbapumpa joe jim";
		assertTrue(s.matches(".*(jim|joe).*"));
	}
}