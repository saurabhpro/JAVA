/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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