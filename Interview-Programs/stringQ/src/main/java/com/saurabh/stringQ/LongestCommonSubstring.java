package com.saurabh.stringQ;

/**
 * http://algorithms.tutorialhorizon.com/dynamic-programming-longest-common-substring/
 * Created by saurabhkumar on 24/07/17.
 */
class LongestCommonSubstring {
    /**
     * @param A
     * @param B
     * @return length of the longest common substring
     */
    static int find(char[] A, char[] B) {

        // Create a table to store lengths of longest common suffixes of
        // substrings.
        //
        // Note that LCS[i][j] contains length of longest
        // common suffix of X[0..i-1] and Y[0..j-1].
        //
        // The first row and first column entries have no logical meaning,
        // they are used only for simplicity of program
        int[][] LCS = new int[A.length + 1][B.length + 1];

        int maxLCSLength = -1;


        /* Following steps build LCSuff[m+1][n+1] in bottom up fashion. */

        //fill the rest of the matrix
        int suffixEnd = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {

                if (i == 0 || j == 0) {
                    // if A or B is null then LCS of A, B =0
                    //or simply put - fill first row and column as 0
                    LCS[i][j] = 0;
                } else if (A[i - 1] == B[j - 1]) {

                    /* Previous Row + Column + 1 (since started with 0th based index */
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;

                    if (maxLCSLength < LCS[i][j]) {
                        maxLCSLength = LCS[i][j];
                        suffixEnd = i;
                    }

                } else {
                    LCS[i][j] = 0;
                }
            }
        }

        System.out.println("\nLongest Common Substring:");
        System.out.println(String.valueOf(A).substring(suffixEnd - maxLCSLength, suffixEnd));


        return maxLCSLength;
    }
}
