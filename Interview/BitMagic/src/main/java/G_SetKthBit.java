/**
 * Set kth bit
 * <p>
 * Given a number N and a value K. From the right, set the Kth bit in the binary representation of N. The position of LSB(or last bit) is 0, second last bit is 1 and so on. Also, 0 <= K < X, where X is the number of bits in the binary representation of N.
 * <p>
 * Input:
 * First line of input contains a single integer T which denotes the number of test cases. T test cases follows. First line of each test case contains two space separated integers N and K.
 * <p>
 * Output:
 * For each test case, print the new number after setting the Kth bit of N.
 * <p>
 * Constraints:
 * 1<=T<=100
 * 1<=N<=1000
 * <p>
 * <p>
 * Example:
 * Input:
 * 2
 * 10 2
 * 15 3
 * Output:
 * 14
 * 15
 * <p>
 * To set any bit we use bitwise OR | operator. As we already know bitwise OR | operator evaluates each bit
 * of the result to 1 if any of the operand's corresponding bit is set (1). In-order to set kth bit of a number
 * we need to shift 1 k times to its left and then perform bitwise OR operation with the number and result
 * of left shift performed just before.
 * <p>
 * In general, (1 << k) | n.
 * Created by saurabhkumar on 31/07/17.
 */
public class G_SetKthBit {
	static int setKthBit(int number, int kthPosition) {

		int temp = 1 << kthPosition;

		return number | temp;
	}
}
