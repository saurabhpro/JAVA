package com.saurabh.sortQ;

import java.util.Arrays;

public class QuickSort implements Sort {

    public static void main(String[] args) {
        Sort sort = new QuickSort();
        System.out.println(Arrays.toString(sort.sort(new int[]{8, 1, 6, 4, 3})));
    }

    public int[] sort(int[] array) {

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        sort(array, 0, array.length - 1);

        return array;
    }

    private void sort(int[] array, int start, int end) {
        System.out.println(Arrays.toString(array));
        int low = start;
        int high = end;
        int pivot = (start + end) / 2;

        while (low <= high) {
            while (array[low] < array[pivot]) {
                low++;
            }

            while (array[high] > array[pivot]) {
                high--;
            }
            if (low <= high)
                exchange(array, low++, high--);
        }
        if (start < high)
            sort(array, start, high);
        if (low < end)
            sort(array, low, end);

    }

    private void exchange(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

}