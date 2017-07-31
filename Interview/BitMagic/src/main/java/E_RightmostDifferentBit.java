/**
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
