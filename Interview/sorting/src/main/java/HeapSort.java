import java.util.Arrays;

public class HeapSort implements Sort {

	public static void main(String[] args) {
		HeapSort heap = new HeapSort();
		System.out.println(Arrays.toString(heap.sort(new int[]{6, 7, 3, 5, 1, 2, 4})));

	}

	public int[] sort(int[] array) {
		System.out.println(Arrays.toString(array));
		int N = array.length;

		for (int i = N / 2; i >= 1; i--) {
			maxSort(array, i, N);
		}

		System.out.println(Arrays.toString(array));
		while (N > 1) {
			exchange(array, 1, N--);
			maxSort(array, 1, N);
		}

		return array;
	}

	private void maxSort(int[] array, int p, int n) {
		while ((2 * p) <= n) {
			int j = 2 * p;

			if (j < n && less(array, j, j + 1))
				j++;

			if (!less(array, p, j))
				break;

			exchange(array, p, j);
			p = j;
		}
	}

	private boolean less(int[] array, int i, int j) {
		System.out.println("less " + array[i - 1] + " " + array[j - 1]);
		return array[i - 1] < array[j - 1];
	}

	private void exchange(int[] array, int p, int k) {
		System.out.println("Exchange " + array[p - 1] + " " + array[k - 1]);
		int temp = array[p - 1];
		array[p - 1] = array[k - 1];
		array[k - 1] = temp;
	}
}