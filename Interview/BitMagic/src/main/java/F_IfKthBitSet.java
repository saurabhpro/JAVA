/**
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
