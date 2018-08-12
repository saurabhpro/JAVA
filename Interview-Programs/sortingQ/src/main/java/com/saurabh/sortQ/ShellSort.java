package com.saurabh.sortQ;

import java.util.Random;

public class ShellSort implements Sort {

    public static void main(String[] args) {
        int[] array = new Random().ints(100).toArray();
        new ShellSort().sort(array);
    }

    public int[] sort(int[] array) {

        int interval = 1;
        while (interval <= array.length / 3) {
            interval = (interval * 3) + 1;
        }

        while (interval > 0) {
            for (int i = interval; i < array.length; i++) {

                int currentIndex = i;

                for (int j = i - interval; j >= 0 && array[j] < array[currentIndex]; j -= interval) {
                    int temp = array[j];
                    array[j] = array[currentIndex];
                    array[currentIndex] = temp;

                    currentIndex -= interval;
                }
            }

            interval = (interval - 1) / 3;
        }

        return array;
    }
}