/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Saurabh on 8/31/2015.
 */
public class InnerClassQ12 {
	public static void main(String[] args) {
		String[] sa = {"nickel", "button", "key", "lint"};
		Sorter s = new Sorter();

		for (String s2 : sa) System.out.print(s2 + " ");

		Arrays.sort(sa, s);

		System.out.println();
		for (String s2 : sa) System.out.print(s2 + " ");
	}

	static class Sorter implements Comparator<String> {
		public int compare(String a, String b) {
			return b.compareTo(a);
		}
	}
}
