package Basics;

import java.util.Arrays;

public class ArraysPrinting {

	public static void main(String[] args) {

		int[] u2 = {4, 8};
		System.out.println(Arrays.toString(u2));

		int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}};
		System.out.println(matrix3); //[[I@1d5a0305

		System.out.println(Arrays.toString(matrix3));
		//[[I@6db3f829, [I@42698403]

		System.out.println(Arrays.deepToString(matrix3));
		//[[1, 2, 3], [4, 5, 6]]
	}
}
