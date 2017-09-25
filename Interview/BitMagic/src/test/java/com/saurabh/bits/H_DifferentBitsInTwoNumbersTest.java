package com.saurabh.bits;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 31/07/17.
 */
public class H_DifferentBitsInTwoNumbersTest {

	@Test
	public void testCountSetBits() throws Exception {
		assertEquals(H_DifferentBitsInTwoNumbers.countSetBits(14), 3);
	}

	@Test
	public void testFlippedCount() throws Exception {
	}

}