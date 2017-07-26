class NextGreaterElement {
	static int[] getNextLargestArray(int[] arr) {
		int currentMaximum = -1;
		int nextMaximum = -1;
		int[] resultArr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			nextMaximum = findNextMaximum(arr, i);

			if (i != arr.length - 1 && nextMaximum == -1) {
				resultArr[i] = currentMaximum;
			} else {
				resultArr[i] = nextMaximum;
			}
		}

		return resultArr;
	}

	/**
	 * @param fromIdx the index from where to begin the search for next maximum number
	 * @return next maximum number starting fromIdx
	 */
	private static int findNextMaximum(int[] arr, int fromIdx) {
		int max = -1;

		for (int i = fromIdx + 1; i < arr.length; i++) {
			if (arr[fromIdx] < arr[i]) {
				max = arr[i];
				break;
			}
		}

		return max;
	}
}