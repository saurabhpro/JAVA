package com.saurabh.commons;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 31/07/17.
 */
public class MathUtilsTest {
	@Test
	public void testLog2() throws Exception {

		assertEquals(MathUtils.log2(2), 1);
		assertEquals(MathUtils.log2(4), 2);
		assertEquals(MathUtils.log2(32), 5);

	}

}