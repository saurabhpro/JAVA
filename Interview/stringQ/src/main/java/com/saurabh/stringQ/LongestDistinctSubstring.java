package com.saurabh.stringQ;

/**
 * Given a string, find length of the longest substring with all distinct characters.  For example, for input "abca", the output is 3 as "abc" is the longest substring with all distinct characters.
 * <p>
 * Input:
 * <p>
 * The first line of input contains an integer T denoting the number of test cases.
 * The first line of each test case is String str.
 * <p>
 * Output:
 * <p>
 * Print length of smallest substring with maximum number of distinct characters.
 * Note: The output substring should have all distinct characters.
 * <p>
 * Constraints:
 * <p>
 * 1 ≤ T ≤ 100
 * 1 ≤ size of str ≤ 10000
 * <p>
 * Example:
 * <p>
 * Input
 * 2
 * abababcdefababcdab
 * geeksforgeeks
 * <p>
 * <p>
 * Output:
 * 6
 * 7
 * http://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string/0
 */
class LongestDistinctSubstring {
	static boolean hasUniqueChars(String str) {
		boolean check = false;
		if (str.length() == 1) return true;
		else {
			for (int i = 0; i < str.length() && !check; i++) {
				for (int j = i + 1; j < str.length(); j++) {
					if (str.charAt(i) == str.charAt(j)) {
						check = true;
						break;
					}
				}
			}
			return !check;
		}
	}

	static String longestDistinctString(String str) {

		String distinct = "";
		String temp = "";

		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				temp = str.substring(i, j);

				if (distinct.length() < temp.length()) {
					if (hasUniqueChars(temp))
						distinct = temp;
					else
						break;
				}
			}

			//answerList[i] = str.substring(i, posRepeatFound-1);
		}

		return distinct;
	}
}