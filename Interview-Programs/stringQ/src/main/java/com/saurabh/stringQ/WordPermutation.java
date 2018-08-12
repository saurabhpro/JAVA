package com.saurabh.stringQ;

import com.saurabh.commons.StringSwappingUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, print all permutations of a given string.
 * <p>
 * Input:
 * <p>
 * The first line of input contains an integer T denoting the number of test cases.
 * Each test case contains a single string in capital letter.
 * <p>
 * Output:
 * <p>
 * Print all permutations of a given string with single space and all permutations should be in lexicographically increasing order.
 * <p>
 * Constraints:
 * <p>
 * 1 ≤ T ≤ 10
 * 1 ≤ size of string ≤ 5
 * <p>
 * Example:
 * <p>
 * Input:
 * 2
 * ABC
 * <p>
 * ABSG
 * <p>
 * Output:
 * ABC ACB BAC BCA CAB CBA
 * <p>
 * ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
 * <p>
 * <p>
 * <p>
 * http://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html
 * Created by saurabhkumar on 23/07/17.
 */
class WordPermutation {

    //imp
    private static Set<String> permWordList = new HashSet<>();

    /* *
     * A method exposed to client to calculate permutation of String in Java.
     */
    static void permutation(String input) {
        permutation("", input);
    }

    /* *
     * Recursive method which actually prints all permutations
     * of given String, but since we are passing an empty String
     * as current permutation to start with,
     * I have made this method private and didn't exposed it to client.
     * */
    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            permWordList.add(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    static int findTotalPermutation(String word) {
        permutation(word);
        return permWordList.size();
    }


    /**
     * permutation function
     * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
     *
     * @param str      string to calculate permutation for
     * @param fromHere starting index
     * @param toHere   end index
     */
    public static void permute(String str, int fromHere, int toHere) {
        if (fromHere == toHere)
            System.out.println(str);
        else {
            for (int i = fromHere; i <= toHere; i++) {
                str = StringSwappingUtils.swapOneCharacter(str, fromHere, i);
                permute(str, fromHere + 1, toHere);
                str = StringSwappingUtils.swapOneCharacter(str, fromHere, i);   //backtrack
            }
        }
    }

}
