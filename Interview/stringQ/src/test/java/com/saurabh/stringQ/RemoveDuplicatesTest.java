package com.saurabh.stringQ;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 23/07/17.
 */
public class RemoveDuplicatesTest {
	@Test
	public void testMakeDuplicateFree() throws Exception {
		assertEquals(RemoveDuplicates.makeDuplicateFree("geeksforgeeks"), "geksfor");
	}

	@Test
	public void testMakeDuplicateFree2() throws Exception {
		assertEquals(RemoveDuplicates.makeDuplicateFree("geeks for geeks"), "geks for");
	}
}