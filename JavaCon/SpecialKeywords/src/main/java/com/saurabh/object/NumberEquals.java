/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package com.saurabh.object;

public class NumberEquals {
    public static void main(String[] args) {
        final int compare = Float.compare(4, 8);

        System.out.println(Double.compare(Double.NaN, Double.NaN));

        System.out.println(Double.compare(-0.0, 0.0));

    }
}
