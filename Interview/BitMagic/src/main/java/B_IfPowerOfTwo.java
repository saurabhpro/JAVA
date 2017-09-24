/**
 * Given a positive integer N, check if N is a power of 2.
 * <p>
 * Input:
 * The first line contains 'T' denoting the number of test cases. Then follows description of test cases.
 * Each test case contains a single positive integer N.
 * <p>
 * <p>
 * Output:
 * Print "YES" if it is a power of 2 else "NO". (Without the double quotes)
 * <p>
 * <p>
 * Constraints:
 * 1<=T<=100
 * 0<=N<=10^18
 * <p>
 * Example:
 * Input :
 * 2
 * 1
 * 98
 * <p>
 * Output :
 * YES
 * NO
 * <p>
 * Explanation:  (2^0 == 1)
 * Created by saurabhkumar on 20/07/17.
 */
class B_IfPowerOfTwo {
	/**
	 * @param n
	 * @return
	 */
	static boolean simpleIsPowerOfTwo(int n) {
		boolean flag = true;
		if (n == 0) return false;
		while (n != 0) {
			if (n == 1)
				return true;
			else if (n % 2 == 1) {
				flag = false;
				break;
			}
			n /= 2;

		}

		return flag;
	}
}
