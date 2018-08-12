package com.saurabh.commons;

/**
 * Created by saurabhkumar on 31/07/17.
 */
public class MathUtils {
    public static int log2(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();

        return 31 - Integer.numberOfLeadingZeros(n);
    }

}
