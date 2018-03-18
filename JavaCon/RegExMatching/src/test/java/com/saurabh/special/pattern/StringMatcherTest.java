/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringMatcherTest {
	private StringMatcher m;

	@BeforeEach
	void setup() {
		m = new StringMatcher();
	}

	@Test
	void testIsTrue() {
		assertTrue(m.isTrue("true"));
		assertFalse(m.isTrue("true2"));
		assertFalse(m.isTrue("True"));
	}

	@Test
	void testIsTrueVersion2() {
		assertTrue(m.isTrueVersion2("true"));
		assertFalse(m.isTrueVersion2("true2"));
		assertTrue(m.isTrueVersion2("True"));
	}

	@Test
	void testIsTrueOrYes() {
		assertTrue(m.isTrueOrYes("true"));
		assertTrue(m.isTrueOrYes("yes"));
		assertTrue(m.isTrueOrYes("Yes"));
		assertFalse(m.isTrueOrYes("no"));
	}

	@Test
	void testContainsTrue() {
		assertTrue(m.containsTrue("thetruewithin"));
	}

	@Test
	void testIsThreeLetters() {
		assertTrue(m.isThreeLetters("abc"));
		assertFalse(m.isThreeLetters("abcd"));
	}

	@Test
	void testisNoNumberAtBeginning() {
		assertTrue(m.isNoNumberAtBeginning("abc"));
		assertFalse(m.isNoNumberAtBeginning("1abcd"));
		assertTrue(m.isNoNumberAtBeginning("a1bcd"));
		assertTrue(m.isNoNumberAtBeginning("asdfdsf"));
	}

	@Test
	void testisIntersection() {
		assertTrue(m.isIntersection("1"));
		assertFalse(m.isIntersection("abcksdfkdskfsdfdsf"));
		assertTrue(m.isIntersection("skdskfjsmcnxmvjwque484242"));
	}

	@Test
	void testLessThenThreeHundred() {
		assertTrue(m.isLessThenThreeHundred("288"));
		assertFalse(m.isLessThenThreeHundred("3288"));
		assertFalse(m.isLessThenThreeHundred("328 8"));
		assertTrue(m.isLessThenThreeHundred("1"));
		assertTrue(m.isLessThenThreeHundred("99"));
		assertFalse(m.isLessThenThreeHundred("300"));
	}

}