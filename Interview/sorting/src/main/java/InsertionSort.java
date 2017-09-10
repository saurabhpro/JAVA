public class InsertionSort implements Sort {

	public static void main(String[] args) {
		Sort algorithm = new InsertionSort();
		algorithm.print("final", algorithm.sort(new int[]{8, 1, 6, 4, 3}));
	}

	public int[] sort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int currentIndex = i;

			for (int j = i - 1; j >= 0; j--) {
				int temp = array[currentIndex];
				int inner = array[j];

				if (temp < inner) {
					array[currentIndex] = array[j];
					array[j] = temp;
					currentIndex--;
				}
			}
		}

		return array;
	}
}