package com.saurabh.commons;

/**
 * Created by Saurabh on 8/21/2015.
 */
public class RecursiveArray {

    static void recurPrint(int[] a, int i, int size)
    {
        if (i < size) {
            System.out.println(a[i]);
            recurPrint(a, i + 1, size);
        }
    }

    public static void main(String[] args)
    {
        int[] a = {4, 6, 7, 7, 7, 7};
        recurPrint(a, 0, a.length);
    }
}
