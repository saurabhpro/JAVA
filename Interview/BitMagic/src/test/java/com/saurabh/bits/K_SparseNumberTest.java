package com.saurabh.bits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by saurabhkumar on 31/07/17.
 */
public class K_SparseNumberTest {
	@Test
	public void testCheckSparse() throws Exception {
	}

	@Test
	public void testNextSparseNumber() throws Exception {
		assertEquals(K_SparseNumber.nextSparseNumber(0), 1);
	}

	@Test
	public void testNextSparseNumber1() throws Exception {
		assertEquals(K_SparseNumber.nextSparseNumber(38), 40);
	}

	@Test
	public void testNextSparseNumber2() throws Exception {
		assertEquals(K_SparseNumber.nextSparseNumber(6), 8);
	}

}