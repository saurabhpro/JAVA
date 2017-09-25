package com.saurabh.stringQ;

import com.saurabh.stringQ.Anagram;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 23/07/17.
 */
public class AnagramTest {
	@BeforeMethod
	public void setUp() throws Exception {
		//	Scanner sc = new Scanner(System.in);

	}

	@Test
	public void testIfAnagramStringYes() throws Exception {
		assertEquals(Anagram.ifAnagramString("atpppc", "tcappp"), true);
	}

	@Test
	public void testIfAnagramStringYes2() throws Exception {
		assertEquals(Anagram.ifAnagramString("geeksforgeeks", "forgeeksgeeks"), true);
	}

	@Test
	public void testIfAnagramStringNo() throws Exception {
		assertEquals(Anagram.ifAnagramString("atc", "tci"), false);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testIfAnagramStringException() throws Exception {
		assertEquals(Anagram.ifAnagramString("atc", "tcan"), false);
	}

}