/**
 * Swap all odd and even bits
 * <p>
 * Given an unsigned integer, swap all odd bits with even bits. For example, if the given number is 23 ( 0 0 0 1 0 1 1 1 ), \
 * it should be converted to 43 ( 0 0 1 0 1 0 1 1 ).
 * <p>
 * Here every even position bit is swapped with adjacent bit on right side
 * (even position bits are highlighted in binary representation of 23),
 * and every odd position bit is swapped with adjacent on left side.
 * <p>
 * Input:
 * <p>
 * The first line of input contains an integer T denoting the number of test cases.
 * Then T test cases follow. The first line of each test case contains an integer N, where N is the number of coins.
 * <p>
 * Output:
 * <p>
 * Corresponding to each test case, print in a new line, the converted number .
 * <p>
 * Constraints:
 * <p>
 * 1 <= T <= 100
 * 1 <= N <= 100
 * <p>
 * Example:
 * <p>
 * Input
 * 2
 * 23
 * 2
 * <p>
 * Output
 * 43
 * 1
 * <p>
 * Approach:
 * 1. We basically make two copies of our input
 * 2. with first we and it with special value of b_1010 -> d_10 -> 0xA's - since it has 1 on every even position
 * 3. if we & with this value, only our even bits values will remain
 * 4. and then we only need to make the >> right shift 1 position
 * <p>
 * 1. Do the exact opposite with Odd places of 4 bits - 0101 -> 5 -> 0x5
 * 2. & with our number
 * 3. and then left shift 1 bit
 * <p>
 * Finally when both numbers are ready - use OR | to combine them
 */
class L_SwapOddEvenBits {

	static int swapBits(int num) {
		// Get all even bits of num
		int even_bits = num & 0xAAAAAAAA;   //0b10101010101010101010101010101010

		// Get all odd bits of num
		int odd_bits = num & 0x55555555;   //0b01010101010101010101010101010101

		even_bits >>= 1;  // Right shift even bits
		odd_bits <<= 1;   // Left shift odd bits

		return (even_bits | odd_bits); // Combine even and odd bits
	}
}
