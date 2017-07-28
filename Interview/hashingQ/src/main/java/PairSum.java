import java.util.HashMap;

/**
 * better solution is possible in O(n) time.
 * <p>
 * Below is the Algorithm.
 * <p>
 * Create a map to store frequency of each number in the array. (Single traversal is required)
 * In the next traversal, for every element check if it can be combined with any other element (other than itself!) to give the desired sum. Increment the counter accordingly.
 * After completion of second traversal, we’d have twice the required value stored in counter because every pair is counted two times. Hence divide count by 2 and return.
 * <p>
 * Created by saurabhkumar on 27/07/17.
 */
public class PairSum {
	// Returns number of pairs in arr[0..n-1] with sum equal to 'sum'

	static int getPairsCount(int[] arr, int sum) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		// Store counts of all elements in map hm
		for (int anArr : arr) {

			// initializing value to 0, if key not found
			//if(!hm.containsKey(arr[i]))
			hm.putIfAbsent(anArr, 0);

			hm.put(anArr, hm.get(anArr) + 1);
		}

		int twice_count = 0;

		/*
		iterate through each element and increment the
		 count (Notice that every pair is counted twice HOW ?)

		 we simply get sum-arr[i] to get the key (which is also part of the array),
		 and hence when we traverse more there will exist sum-key == arr[i]

		 both these will satisfy the pair sum, but 5 + 1 or 1 + 5 is same , hence divide the result by 2
		 */
		for (int anArr : arr) {

			//use default value else get() throws exception if not present
			twice_count += hm.getOrDefault(sum - anArr, 0);

			// if {arr[i] -> 1, arr[i] -> 1} pair satisfies the condition,
			// then we need to ensure that the count is
			// decreased by one such that the {arr[i] -> 1, arr[i] -> 1} pair is not considered
			/* that is ar[i] should only be paired with anything other than itself */
			if (sum - anArr == anArr)   //{1,1,1} & sum = 2
				twice_count--;
		}

		// return the half of twice_count
		return twice_count / 2;
	}
}
