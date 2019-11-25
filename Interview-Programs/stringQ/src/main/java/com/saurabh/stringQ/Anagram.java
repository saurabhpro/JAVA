package com.saurabh.stringQ;

/**
 * Given two strings, check whether two given strings are anagram of each other or not. An anagram of a string is another string that contains same characters, only the order of characters can be different. For example, “act” and “tac” are anagram of each other.
 * <p>
 * Input:
 * <p>
 * The first line of input contains an integer T denoting the number of test cases. Each test case consist of two strings in 'lowercase' only, in a separate line.
 * <p>
 * Output:
 * <p>
 * Print "YES" without quotes if the two strings are anagram else print "NO".
 * <p>
 * Constraints:
 * <p>
 * 1 ≤ T ≤ 30
 * <p>
 * 1 ≤ |s| ≤ 100
 * <p>
 * Example:
 * <p>
 * Input:
 * 2
 * geeksforgeeks
 * forgeeksgeeks
 * allergy
 * allergic
 * <p>
 * Output:
 * YES
 * NO
 * Created by saurabhkumar on 23/07/17.
 */
class Anagram {

    /**
     *
     * @param str1
     * @param str2
     * @return
     */
    static boolean ifAnagramString(String str1, String str2) {
        if (str1.length() != str2.length()) {
            throw new IllegalArgumentException("both strings have different length");
        }

        boolean check = true;
        char[] charCount = new char[26];

        makeCharCountArray(charCount, str1, str2);

        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) {
                check = false;
                break;
            }
        }
        return check;
    }

    private static void makeCharCountArray(char[] charCount, String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.toLowerCase().charAt(i) - 91]++;

            charCount[str2.toLowerCase().charAt(i) - 91]--;
        }
    }
}
