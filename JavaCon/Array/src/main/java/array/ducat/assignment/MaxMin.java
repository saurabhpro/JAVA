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
class MaxMin {

	private final ArrayD ar = new ArrayD();

	int max(int a[]) {
		int max = a[0];
		for (int i = 1; i < a.length; ++i) {
			if (a[i] > max)
				max = a[i];
		}
		ar.print(a);
		return max;

	}

	int max(int a[][]) {
		int max = a[0][0];
		for (int i = 1; i < a.length; ++i) {
			for (int j = 0; j < a[i].length; ++j)
				if (a[i][j] > max)
					max = a[i][j];
		}
		ar.print(a);
		return max;
	}

	int min(int a[]) {
		int min = a[0];
		for (int i = 1; i < a.length; ++i) {
			if (a[i] < min)
				min = a[i];
		}
		ar.print(a);
		return min;
	}

	int min(int a[][]) {
		int min = a[0][0];
		for (int i = 1; i < a.length; ++i) {
			for (int j = 0; j < a[i].length; ++j)
				if (a[i][j] < min)
					min = a[i][j];
		}
		ar.print(a);
		return min;
	}
}
