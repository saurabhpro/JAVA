package com.saurabh.bits;

/**
 * Created by saurabhkumar on 31/07/17.
 */
public class I_MaxConsecutiveOnes {
	static int numberOfConsecutiveOnesFromRight(int num) {

		// Initialize result
		int count = 0;

		// Count the number of iterations to
		// reach x = 0.
		while (num != 0) {
			// This operation reduces length
			// of every sequence of 1s by one.
			num = num & (num << 1);

			count++;
		}

		return count;
	}
}
