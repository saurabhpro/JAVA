/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package annotations;

import java.util.ArrayList;
import java.util.Arrays;

public class SafeVarArgs {
	@SafeVarargs    // possible heap pollution warning without it
	private static <T> void showArgs(T... array) {
		for (T arg : array) {
			String s = arg.getClass().getName() + ":" + arg;
			System.out.println(s);
		}

		/* OUTPUT
		java.util.ArrayList:[1, 2]  //see no -> Generic information present
		java.lang.Long:12
		 */
	}

	public static void main(String[] args) {
		ArrayList<Long> a1 = new ArrayList<>();
		a1.add(1L);
		a1.add(2L);
		showArgs(a1, 12L);

		SafeVarArgs sf = new SafeVarArgs();
		sf.java9Thing(55, 88);
	}

	@SafeVarargs    // only usable on non-reifable type , just cange the T with Integer and you wont need it
	private <T> void java9Thing(T... array) {
		Arrays.stream(array).map(arg -> arg.getClass().getName() + ":" + arg).forEach(System.out::println);

		/* OUTPUT
		java.lang.Integer:55
		java.lang.Integer:88
		 */
	}
}
