import java.util.Scanner;

/**
 * Given an integer an N, write a program to print the position of first set bit found from right side
 * in the binary representation of the number.
 * <p>
 * Input:
 * The first line of the input contains an integer T, denoting the number of test cases. Then T test cases follow.
 * The only line of the each test case contains an integer N.
 * <p>
 * Output:
 * For each test case print in a single line an integer denoting the position of the first set bit found form right
 * side of the binary representation of the number.
 * <p>
 * Constraints:
 * 1<=T<=100
 * 0<=N<=10^6
 * <p>
 * Example:
 * Input:
 * 2
 * 18
 * 12
 * <p>
 * Output:
 * 2
 * 3
 * <p>
 * Explanation:
 * Test case 1:
 * Binary representation of the 18 is 010010, the first set bit from the right side is at position 2.
 * <p>
 * Created by saurabhkumar on 19/07/17.
 */
public class A_FindFirstSetBit {

	public static void main(String[] args) {
		int N, T;
		Scanner sc = new Scanner(System.in);

		//Read number of Test Cases from STDIN
		T = sc.nextInt();

		if (T < 1 || T > 100) {
			System.out.println("Test Cases Invalid (Allowed range 1-100): ");
		} else {
			for (int i = 0; i < T; i++) {
				//Read ith Value which is to be processed
				N = sc.nextInt();
				if (N < 0 || N > 1000000) {
					System.out.println("Input Value out of Range (Allowed Range 0-10^6)");
				} else {
					int result = simpleFirstSetBitInNumber(N);
					System.out.println("Number " + N + " in binary format is " + Integer.toBinaryString(N));
					System.out.println(result == 0 ? "Number is 0" : "Position of First Set Bit From Right in " + N + " is " + result);
				}

			}
		}
		sc.close();

	}

	static int simpleFirstSetBitInNumber(int n) {

		if (n <= 0) {
			return 0;
		}
		if (n % 2 != 0) {
			return 1;   //if a number is odd first bit from right will be 1
		}

		int position = 1;
		while (n % 2 != 1) {
			n /= 2;
			position++;
		}

		return position;
	}

	static int smartFirstSetBitInNumber(int n) {
		/*
		1. Take two's complement of the given no as all bits are reverted
		except the first '1' from right to left (10111)

		2  Do an bit-wise & with original no, this will return no with the
		required one only (00010)

		3  Take the log2 of the no, you will get position -1 (1)

		4  Add 1 (2)

		 */

		return MathUtils.log2(n & -n) + 1;

	}


}
