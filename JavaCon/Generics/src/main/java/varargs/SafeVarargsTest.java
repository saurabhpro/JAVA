/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package varargs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by saurabhkumar on 10/09/17.
 */
public class SafeVarargsTest {
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(1);
		a1.add(2);

		showArgs(a1, 12);

		main2();

		SafeVarargsTest safeVarargsTest = new SafeVarargsTest();
		safeVarargsTest.goodVarargsMethod(Arrays.asList("North", "South"), Arrays.asList("Up", "Down"));
		//to see warnings - compile using
		//javac -Xlint:unchecked varargs.SafeVarargsTest.java
	}

	@SafeVarargs
	public static <T> void showArgs(T... array) {
		for (T arg : array) {
			System.out.println(arg.getClass().getName() + ":" + arg);
		}
	}

	@SafeVarargs
	private static void call(List<String>... stringLists) {
		String s = stringLists[0].get(0);
		System.out.println(s);
	}

	public static void main2() {
		List<String> myList1 = new ArrayList<>();
		List<String> myList2 = new ArrayList<>();

		myList1.add("Hi");
		myList2.add("Hi");

		call(myList1, myList2);
	}

	//@SafeVarargs    //from java 9 non-final private methods too
	private void goodVarargsMethod(List<String>... ls) {
		for (List<String> los : ls)
			System.out.println(los);
	}
}