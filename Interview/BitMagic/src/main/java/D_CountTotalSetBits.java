/**
 * Find the sum of all bits from numbers 1 to N.
 * <p>
 * Input:
 * <p>
 * The first line of input contains an integer T denoting the number of test cases.
 * The first line of each test case is N.
 * <p>
 * Output:
 * <p>
 * Print the sum of all bits.
 * <p>
 * Constraints:
 * <p>
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 1000
 * <p>
 * Example:
 * <p>
 * Input:
 * 2
 * 4
 * 17
 * <p>
 * Output:
 * 5
 * 35
 * <p>
 * Explanation:
 * An easy way to look at it is to consider the number 6:
 * 0|0 0
 * 0|0 1
 * 0|1 0
 * 0|1 1
 * -|–
 * 1|0 0
 * 1|0 1
 * 1|1 0
 * Created by saurabhkumar on 21/07/17.
 */
class D_CountTotalSetBits {
	/**
	 * @param n
	 * @return
	 */
	static int countTotalSetBitsTillNumber(int n) {

		if (n < 0) {
			throw (new IllegalArgumentException("Out of Range: Value Entered is less than 0"));
		}

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += getSetBitCountForNumber(i);
		}
		return sum;

	}

	/**
	 * @param n
	 * @return
	 */
	static int getSetBitCountForNumber(int n) {
		int counter = 0;
		while (n != 0) {
			n = n & (n - 1);
			counter++;
		}
		//	System.out.println(counter);
		return counter;
	}

}
