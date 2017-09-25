package com.saurabh.sortQ;

public class BubbleSort implements Sort {

	public static void main(String[] args) {
		Sort algorithm = new BubbleSort();
		algorithm.print("final", algorithm.sort(new int[]{8, 1, 3, 4, 6}));
	}

	public int[] sort(int[] array) {
		int temp;

		for (int i = 0; i < array.length; i++) {
			boolean swapped = false;

			for (int j = 1; j < array.length; j++) {

				if (array[j - 1] < array[j]) {

					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;

					swapped = true;
				}
			}

			if (!swapped)
				break;
		}

		return array;
	}
}