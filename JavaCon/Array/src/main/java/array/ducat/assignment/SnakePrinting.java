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
class SnakePrinting {
	private final ArrayD ar = new ArrayD();

	void printDiagonally(int a[][]) {
		ar.print(a);
		int i, j;
		i = j = 0;
		int max, imin, jmin;
		max = a.length - 1;
		imin = jmin = 0;

		while (imin <= max && jmin <= max) {
			i = imin;
			j = jmin;
			while (i >= jmin)
				//  System.out.println("imin ="+ imin+" jmin= "+ jmin+ " i = "+ (i-1)+" j = "+ (j+1));
				System.out.print(a[i--][j++] + " ");

			System.out.println();
			if (imin == max)
				jmin++;
			else
				imin++;
		}
	}

	void printSnakes(int a[][]) {
		ar.print(a);

		int imin, jmin;
		imin = jmin = 0;
		int iteration = 0;
		int max = a.length - 1;
		int i, j;
		i = j = 0;

		while (iteration <= a.length + 2) {
			if (iteration % 2 == 0) {
				if (iteration > max) {
					i = max;
					jmin = imin = iteration - max;
					j = jmin;
				} else {
					i = iteration - jmin;
					j = jmin;
				}
				while ((i + j) == iteration && i >= imin && j >= jmin) {
					// System.out.println("UTD imin ="+ imin+" jmin= "+ jmin+ " i = "+ (i)+" j = "+ (j));
					System.out.print(a[i--][j++] + " ");
				}
				System.out.println();
			} else {
				if (iteration > max) {
					j = max;
					imin = jmin = iteration - max;
					i = imin;
				} else {
					j = iteration - imin;
					i = imin;
				}
				while ((i + j) == iteration && i >= imin && j >= jmin) {
					//System.out.println("DTU imin =" + imin + " jmin= " + jmin + " i = " + i + " j = " + j);
					System.out.print(a[i++][j--] + " ");
				}
				System.out.println();
			}

			iteration++;
		}
	}
}
