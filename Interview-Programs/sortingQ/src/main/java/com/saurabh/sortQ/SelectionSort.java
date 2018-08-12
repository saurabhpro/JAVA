package com.saurabh.sortQ;

public class SelectionSort implements Sort {

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;
            int min = array[i];

            for (int j = i; j < array.length; j++) {
                int minCandidate = array[j];

                if (minCandidate < min) {
                    min = minCandidate;
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}