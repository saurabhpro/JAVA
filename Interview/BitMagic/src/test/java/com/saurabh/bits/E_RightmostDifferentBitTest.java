package com.saurabh.bits;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 31/07/17.
 */
public class E_RightmostDifferentBitTest {
	@Test
	public void testGetRightmostDifferentBitPosition() throws Exception {
		assertEquals(E_RightmostDifferentBit.getRightmostDifferentBitPosition(52, 4), 5);
	}

	@Test
	public void testGetRightmostDifferentBitPosition2() throws Exception {
		assertEquals(E_RightmostDifferentBit.getRightmostDifferentBitPosition(11, 9), 2);
	}

}