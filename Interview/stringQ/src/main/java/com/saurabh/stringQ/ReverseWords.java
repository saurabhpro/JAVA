package com.saurabh.stringQ;

/**
 * Given a String of length N reverse the words in it. Words are separated by dots.
 * <p>
 * Input:
 * The first line contains T denoting the number of testcases. Then follows description of testcases. Each case contains a string containing spaces and characters.
 * <p>
 * <p>
 * Output:
 * For each test case, output a single line containing the reversed String.
 * <p>
 * Constraints:
 * 1<=T<=10
 * 1<=Lenght of String<=2000
 * <p>
 * <p>
 * Example:
 * Input:
 * 2
 * i.like.this.program.very.much
 * pqr.mno
 * <p>
 * Output:
 * much.very.program.this.like.i
 * mno.pqr
 * Created by saurabhkumar on 23/07/17.
 */
public class ReverseWords {
	/**
	 * @param str
	 * @return
	 */
	static String reverseWordsInSentence(String str) {
		String[] wordArr = str.split("[.]");        //since . has special meaning
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = wordArr.length - 1; i > 0; i--) {
			stringBuilder.append(wordArr[i]);
			stringBuilder.append(".");
		}

		stringBuilder.append(wordArr[0]);

		return stringBuilder.toString();
	}
}
