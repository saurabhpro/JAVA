package com.saurabh.stringQ;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 23/07/17.
 */
public class ReverseWordsTest {
	@Test
	public void testReverseWordsInSentence() throws Exception {
		assertEquals(ReverseWords.reverseWordsInSentence("i.like.this.program.very.much"), "much.very.program.this.like.i");
	}

	@Test
	public void testReverseWordsInSentence2() throws Exception {
		//	assertEquals(com.saurabh.stringQ.ReverseWords.reverseWordsInSentence("i.like.this.program.very..."), "...very.program.this.like.i");
	}

}