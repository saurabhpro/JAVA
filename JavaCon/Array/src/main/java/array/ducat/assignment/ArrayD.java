/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
