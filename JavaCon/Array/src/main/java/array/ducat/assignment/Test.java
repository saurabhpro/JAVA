/*
 * Copyright (c) 2018 Saurabh Kumar
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