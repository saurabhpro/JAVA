/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package array.ducat.assignment;

/**
 * Created by Saurabh on 7/6/2015.
 */
public class ArrayD {
	public static void main(String[] args) {
		//  int choice = 0;
		//   System.out.println("Menu\1.Min Max\n2. Union\n3. Intersection\n4. 2D Matrix Sum\n5. 2D Matrix");
	  /*  array.ducat.assignment.MaxMin obj = new array.ducat.assignment.MaxMin();

        System.out.println( obj.max(new int[]{1, 7, 9, 8}));
        System.out.println(obj.max(new int[][]{{1, 7, 9, 8}, {5,6,7,2,9,12}}));

        array.ducat.assignment.TriangleSum tsum = new array.ducat.assignment.TriangleSum();
        System.out.println(tsum.lowerTriangleSum(new int[][]{{1, 2, 3}, {4,5, 6}, {7,8,9}}));
        System.out.println(tsum.upperTriangleSum(new int[][]{{1, 2, 3}, {4,5, 6}, {7,8,9}}));
*/
		SnakePrinting sprin = new SnakePrinting();
		sprin.printDiagonally(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
	     /*OutPut
       1    2    3
       4    5    6
       7    8    9
        1
        4 2
        7 5 3
        8 6
        9
        */
		sprin.printSnakes(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
	    /*
       1    2    3    4
       5    6    7    8
       9   10   11   12
      13   14   15   16
        1
        2 5
        9 6 3
        4 7 10 13
        14 11 8
        12 15
        16

       */
	}

	void print(int a[]) {
		for (int anA : a) System.out.printf("%4d ", anA);

		System.out.println();
	}

	void print(int a[][]) {
		for (int[] anA : a) {
			for (int anAnA : anA) {
				System.out.printf("%4d ", anAnA);
			}
			System.out.println();
		}
	}
}
