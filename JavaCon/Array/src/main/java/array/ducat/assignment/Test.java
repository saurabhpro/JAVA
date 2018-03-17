/*
 * Copyright 2017 Saurabh Kumar 29/10/17 11:24 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package array.ducat.assignment;

class Test1 {
	public static void main(String args[]) {
		int arr[] = new int[2];
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
}
// Java arrays are first class objects and all members of objects are initialized with default values like o, null.

class Test2 {
	public static void main(String[] args) {
		int arr1[] = {1, 2, 3};
		int arr2[] = {1, 2, 3};
		if (arr1 == arr2)
			System.out.println("Same");
		else
			System.out.println("Not same");
	}
}

class Test3ForTransposeOfAMatrix {
	public static void main(String[] args) {
		int[][] M = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

		int i, j, t;
		for (i = 0; i < 4; ++i) {
			for (j = i; j < 4; ++j) {
				t = M[i][j];
				M[i][j] = M[j][i];
				M[j][i] = t;
			}
		}
		for (i = 0; i < 4; ++i)
			for (j = 0; j < 4; ++j)
				System.out.printf("%d", M[i][j]);
	}
}

class Test4 {
	public static void main(String[] args) {
		Double object = Double.valueOf("2.4");
		int a = object.intValue();
		System.out.println(a);
		byte b = object.byteValue();
		System.out.println(b);
		float d = object.floatValue();
		System.out.println(d);
		double c = object;
		System.out.println(c);

		System.out.println(a + b + c + d);     // 8.800000095367432
		// 2+2+2.4+2.4  // 8.8 ? but float value is not very accurate in arithmetic so some remnant will be there

		/*
		Arithmetic conversions are implicitly performed to cast the values to a common type.
		The compiler first performs integer promotion. If the operands still have different types,
		then they are converted to the type that appears highest in the hierarchy.
		 */
	}
}