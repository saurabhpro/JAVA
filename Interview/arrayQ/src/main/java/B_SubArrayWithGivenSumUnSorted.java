/**
 * Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.
 * <p>
 * Input:
 * <p>
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.
 * <p>
 * Output:
 * <p>
 * Corresponding to each test case, in a new line, print the starting and ending positions of first such occuring subarray if sum equals to subarray, else print -1.
 */
class B_SubArrayWithGivenSumUnSorted {

	int subArraySumEfficient(int[] arr, int n, int requiredSum) {
		int curr_sum = arr[0], start = 0, i;

		// Pick a starting point
		for (i = 1; i <= n; i++) {
			// If curr_sum exceeds the requiredSum, then remove the starting elements
			while (curr_sum > requiredSum && start < i - 1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			// If curr_sum becomes equal to requiredSum, then return true
			if (curr_sum == requiredSum) {
				int p = i - 1;
				System.out.println("Sum found between indexes " + start + " and " + p);
				return 1;
			}

			// Add this element to curr_sum
			if (i < n)
				curr_sum = curr_sum + arr[i];

		}

		System.out.println("No subarray found");
		return 0;
	}


	/* Returns true if the there is a subarray of arr[] with sum equal to 'sum'
   otherwise returns false.  Also, prints the result */
}
