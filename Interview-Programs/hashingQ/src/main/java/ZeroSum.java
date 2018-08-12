import java.util.HashMap;

class ZeroSum {
    /*
    We can Use Hashing to solve this problem in O(n) time. The idea is to iterate through the array
    and for every element arr[i], calculate sum of elements form 0 to i (this can simply be done as
    sum += arr[i]).

    If the current sum has been seen before, then there is a zero sum array.
    Hashing is used to store the sum values, so that we can quickly store sum and find out whether
    the current sum is seen before or not.
    */
    // Returns length of the maximum length subarray with 0 sum
    static int maxLen(int arr[]) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];

            if (arr[i] == 0 && max_len == 0)
                max_len = 1;

            if (sum == 0)
                max_len = i + 1;

            // Look this sum in hash table
            Integer prev_i = hM.get(sum);

            // If this sum is seen before, then update max_len
            // if required
            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else // Else put this sum in hash table
                hM.put(sum, i);
        }

        return max_len;
    }

    // Returns length of the largest subarray with 0 sum
    int maxLen(int[] arr, int n) //O(n^2)
    {
        int max_len = 0; // Initialize result

        // Pick a starting point
        for (int i = 0; i < n; i++) {
            // Initialize currr_sum for every starting point
            int curr_sum = 0;

            // try all subarrays starting with 'i'
            for (int j = i; j < n; j++) {
                curr_sum += arr[j];

                // If curr_sum becomes 0, then update max_len
                // if required
                if (curr_sum == 0)
                    max_len = Math.max(max_len, j - i + 1);
            }
        }
        return max_len;
    }
}