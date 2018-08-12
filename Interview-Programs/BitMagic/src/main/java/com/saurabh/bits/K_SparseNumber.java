package com.saurabh.bits;

/**
 * Created by saurabhkumar on 31/07/17.
 */
public class K_SparseNumber {

    static boolean checkSparse(int n) {
        // n is not sparse if there is set
        // in AND of n and n/2
        return (n & (n >> 1)) == 0;
    }


    static int nextSparseNumber(int n) {

        return 0;
    }

}
