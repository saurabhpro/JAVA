package com.saurabh.stringQ;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 23/07/17.
 */
public class ParenthesisCheckerTest {
	@Test
	public void testIsParenthesisBalanced() throws Exception {
		assertEquals(ParenthesisChecker.isParenthesisBalanced("{([])}"), true);
		assertEquals(ParenthesisChecker.isParenthesisBalanced("()[]"), true);
		assertEquals(ParenthesisChecker.isParenthesisBalanced("[()]{}{[())]()}"), false);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testIsParenthesisBalancedErr() throws Exception {
		assertEquals(ParenthesisChecker.isParenthesisBalanced("{([top])}"), true);
	}

	@Test
	public void testFindMatch() throws Exception {
		assertEquals(ParenthesisChecker.findMatch('{', '}'), true);
	}

	@Test
	public void testFindMatchNo() throws Exception {
		assertEquals(ParenthesisChecker.findMatch('{', ')'), false);
	}

}