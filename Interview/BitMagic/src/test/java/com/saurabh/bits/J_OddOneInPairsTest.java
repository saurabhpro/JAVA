package com.saurabh.bits;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 31/07/17.
 */
public class J_OddOneInPairsTest {
	@Test
	public void testOddOneInPair() throws Exception {
		assertEquals(J_OddOneInPairs.oddOneInPair(new int[]{1, 2, 3, 2, 1}), 3);
	}

}