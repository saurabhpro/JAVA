package com.saurabh.stringQ;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 23/07/17.
 */
public class WordPermutationTest {
	@Test
	public void testPermute() throws Exception {
		String str = "AAC";
		int n = str.length();
		WordPermutation.permute(str, 0, n - 1);
	}

	@Test
	public void testPermutation() throws Exception {
		WordPermutation.permutation("AAC");
		//TODO
	}

	@Test
	public void testFindTotalPermutation() throws Exception {
		assertEquals(WordPermutation.findTotalPermutation("AAC"), 3);
	}

}