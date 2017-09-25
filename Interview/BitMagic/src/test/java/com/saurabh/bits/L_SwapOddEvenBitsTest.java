package com.saurabh.bits;

import org.testng.Assert;
import org.testng.annotations.Test;

public class L_SwapOddEvenBitsTest {
	@Test
	public void testSwapBitsOf2() throws Exception {
		Assert.assertEquals(L_SwapOddEvenBits.swapBits(2), 1);
	}

	@Test
	public void testSwapBitsOf23() throws Exception {
		Assert.assertEquals(L_SwapOddEvenBits.swapBits(23 /*00010111*/), 43/*00101011*/);
	}
}