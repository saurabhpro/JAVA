/**
 * Check whether K-th bit is set or not
 * <p>
 * Given a number  N and  a bit number K, check if K-th bit of N is set or not. A bit is called set if it is 1. Position of  set bit '1' should be indexed starting with 0 from LSB side in binary representation of the number. For example, for N = 4(100), 0th bit = 0, 1st bit = 0, 2nd bit = 1.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case contain an integer  N. The second line of each test case contains a n integer  K.
 * <p>
 * Output:
 * Corresponding to each test case, print "Yes" (without quotes) if K-th  bit is set else print "No" (without quotes) in a new line.
 * <p>
 * Constraints:
 * 1 <= T <= 200
 * 1 <= N <= 1000000000
 * 0 <= K <= floor(log2(N) + 1)
 * <p>
 * Example:
 * Input
 * 3
 * 4
 * 0
 * 4
 * 2
 * 500
 * 3
 * <p>
 * Output
 * No
 * Yes
 * No
 * <p>
 * Below are simple steps to find value of k-th bit
 * <p>
 * 1) Left shift given number 1 by k-1 to create
 * a number that has only set bit as k-th bit.
 * temp = 1 << (k-1)
 * 2) If bitwise AND of n and temp is non-zero,
 * then result is SET else result is NOT SET.
 * Example:
 * <p>
 * n = 75 and k = 4
 * temp = 1 << (k-1) = 1 << 3 = 8
 * Binary Representation of temp = 0..00001000
 * Binary Representation of n = 0..01001011
 * Since bitwise AND of n and temp is non-zero,
 * result is SET.
 * Created by saurabhkumar on 31/07/17.
 */
class F_IfKthBitSet {
	static boolean ifKthBitIsSet(int number, int kthPosition) {

		int temp = 1 << (kthPosition - 1);

		return (number & temp) != 0;
	}
}
