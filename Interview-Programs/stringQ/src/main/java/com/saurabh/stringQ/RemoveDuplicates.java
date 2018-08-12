package com.saurabh.stringQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove Duplicates
 * Show Topic Tags         Microsoft
 * Given a string, remove duplicates from it. Note that original order of characters must be kept same.  Expected time complexity O(n) where n is length of input string and extra space O(1) under the assumption that there are total 256 possible characters in a string.
 * <p>
 * Input: First line of the input is the number of test cases T. And first line of test case contains a string.
 * <p>
 * Output:  Modified string without duplicates and same order of characters.
 * <p>
 * Constraints:  Input String Length <= 1000
 * <p>
 * Example:
 * Input:
 * 2
 * geeksforgeeks
 * geeks for geeks
 * <p>
 * Output:
 * geksfor
 * geks for
 * Created by saurabhkumar on 23/07/17.
 */
class RemoveDuplicates {
    /**
     * @param str
     * @return
     */
    static String makeDuplicateFree(String str) {
        List<Character> newArr = new ArrayList<>();
        StringBuilder st = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (!newArr.contains(ch)) {
                newArr.add(ch);
                st.append(ch);
            }
        }

        return st.toString();
    }
}
