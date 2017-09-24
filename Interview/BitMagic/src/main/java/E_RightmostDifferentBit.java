/**
 * Given two numbers M and N. Write a program to find the position of rightmost different bit in binary representation of numbers.
 * <p>
 * Input:
 * First line of input contains a single integer T which denotes the number of test cases. T test cases follows. First line of each test case contains two space separated integers M and N.
 * <p>
 * Output:
 * For each test case print the position of rightmost different bit in binary representation of numbers. If both M and N are same then print -1 in this case.
 * <p>
 * Constraints:
 * 1<=T<=100
 * 1<=M<=1000
 * 1<=N<=1000
 * <p>
 * Example:
 * Input:
 * 2
 * 11 9
 * 52 4
 * Output:
 * 2
 * 5
 * <p>
 * Approach: Get the bitwise xor of m and n. Let it be xor_value = m ^ n. Now, find the position of rightmost set bit in xor_value.
 * <p>
 * Explanation: The bitwise xor operation produces a number which has set bits only at the positions where the bits of m and n differ.
 * Thus, the position of rightmost set bit in xor_value gives the position of rightmost different bit.
 * Created by saurabhkumar on 31/07/17.
 */
public class E_RightmostDifferentBit {
	static int getRightmostDifferentBitPosition(int num1, int num2) {
		//if you think hard rightmost set will also be the first set bit in the xor result
		return A_FindFirstSetBit.smartFirstSetBitInNumber(num1 ^ num2);
	}
}
