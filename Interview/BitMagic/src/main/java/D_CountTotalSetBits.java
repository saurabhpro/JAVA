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
 * 1 <=T <= 100
 * 1 <=N <= 1000
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
 * -|-
 * 1|0 0
 * 1|0 1
 * 1|1 0
 * Created by saurabhkumar on 21/07/17.
 */
class D_CountTotalSetBits {

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
	 * Approach -
	 * 1. make sure the value is non-zero
	 * 2. we know that 1 & 0 = 0 - basically the truth table for AND
	 * 3. while num is not 0 again, we AND [num & num-1] (last bit changes!) - we then increment the counter
	 * Ex. - 2 (0010) & (2-1)(0001) = 0 - hence counter = 1
	 * Ex2 - 128 (1000 0000) & 127(0111 1111) -> c = 1
	 * <p>
	 * Ex3 -
	 * num = 30 (0001 1110) & (0001 1101) -> num = 28(0001 1100), c1 = 1 [see how 29 and 30 only differ by 1 bit]
	 * num = 28 (0001 1100) & (0001 1011) -> num = 24(0001 1000), c1= 2
	 * num = 24 (0001 1000) & (0001 0111) -> num = 16(0001 0000), c1 = 3
	 * num = 16 (0001 0000) & (0000 1111) -> num = 0, c1 = 4
	 * LOOP ENDS
	 * Hence counter = 4 and we know that 30 has 4 set bits
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
