package com.saurabh.sortQ;

public class MergeSort implements Sort {

	public static void main(String[] args) {
		Sort algorithm = new MergeSort();
		algorithm.print("final", algorithm.sort(new int[]{2, 6, 3, 6, 8, 9, 0, 6, 4, 4, 3, 7, 5, 1}));
	}

	public int[] sort(int[] array) {

		int[] tmp = new int[array.length];

		mergeSort(array, tmp, 0, array.length - 1);

		return tmp;
	}

	private void mergeSort(int[] array, int[] tmp, int start, int end) {
		if (end <= start) {
			return;
		}

		int middle = (end + start) / 2;
		mergeSort(array, tmp, start, middle);
		mergeSort(array, tmp, middle + 1, end);

		int i = start;
		int j = middle + 1;

		int resultIdx = 0;

		while (i <= middle && j <= end) {
			if (array[i] < array[j]) {
				tmp[resultIdx] = array[i];

				i++;
			} else {
				tmp[resultIdx] = array[j];
				j++;
			}
			resultIdx++;
		}

		for (int iCopy = i; iCopy <= middle; iCopy++) {
			tmp[resultIdx++] = array[iCopy];
		}
		for (int iCopy = j; iCopy <= end; iCopy++) {
			tmp[resultIdx++] = array[iCopy];
		}

		System.arraycopy(tmp, 0, array, start, (end - start) + 1);
	}
}