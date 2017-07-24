/**
 * Given an integer N and an integer D, you are required to write a program to rotate the binary representation of the integer N by D digits to the left as well as right and print the results in decimal values after each of the rotation.
 * <p>
 * Note: Integer N is stored using 16 bits. i.e. 12 will be stored as 0000.....001100.
 * <p>
 * Input:
 * First line of input contains a single integer T which denotes the number of test cases. First line of each test case contains two space separated integers N and D where N denotes the number to be rotated and D denotes the number of digits by which the number is required to be rotated.
 * <p>
 * Output:
 * For first line of each test case print the value of number N after rotating it to left by D digits. For second line of each test case print the value of number N after rotating it to the right by D digits.
 * <p>
 * Constraints:
 * 1<=T<=100
 * 1<=N<=1000
 * 1<=D<=100
 * <p>
 * Example:
 * Input:
 * 2
 * 229 3
 * 28 2
 * Output:
 * 47
 * 188
 * 19
 * 7
 * Created by saurabhkumar on 20/07/17.
 */
class C_RotateBitsLeft {
	/**
	 * @param n
	 * @param distance
	 * @return
	 */
	static int rotateLeft(int n, int distance) {
		int leftOnly = n << distance;
		int rightNegative = n >>> -distance;

		System.out.println(leftOnly + " : " + Integer.toBinaryString(leftOnly));
		System.out.println(rightNegative + " : " + Integer.toBinaryString(rightNegative));
		return (n << distance) | (n >>> -distance);
	}
}
//0000 0000 0000 0000 0000 0000 0000 0000 0001 0000