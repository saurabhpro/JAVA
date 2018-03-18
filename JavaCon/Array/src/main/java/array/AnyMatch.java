/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package array;

import java.util.stream.IntStream;

public class AnyMatch {
	public static void main(String[] args) {
		setZeros(new int[][]{});
	}

	public static void setZeros(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero;

		// Check if first row has a zero
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}

		// Check if first column has a zero
		colHasZero = IntStream.range(0, matrix.length).allMatch(i -> matrix[i][0] == 0);
	}
}