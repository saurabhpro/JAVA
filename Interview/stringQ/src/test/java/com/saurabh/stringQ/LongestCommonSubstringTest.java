package com.saurabh.stringQ;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 24/07/17.
 */
public class LongestCommonSubstringTest {
	@Test
	public void testFind() throws Exception {
		String A = "tutorialhorizon";
		String B = "dynamictutorialProgramming";
		System.out.println("LCS length : " + LongestCommonSubstring.find(A.toCharArray(), B.toCharArray()));

	}

	@Test
	public void testFind2() {
		String s1 = "OldSite:GeeksforGeeks.org";
		String s2 = "NewSite:GeeksQuiz.com";
		assertEquals(LongestCommonSubstring.find(s1.toCharArray(), s2.toCharArray()), 10);
	}
}