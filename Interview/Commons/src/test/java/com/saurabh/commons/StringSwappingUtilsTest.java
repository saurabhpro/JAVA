package com.saurabh.commons;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 23/07/17.
 */
public class StringSwappingUtilsTest {
	@Test
	public void testSwapOneCharacter() throws Exception {
		assertEquals(StringSwappingUtils.swapOneCharacter("ABCDE", 2, 4), "ABEDC");
	}

}