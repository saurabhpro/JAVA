/*
 * Copyright (c) 2018 Saurabh Kumar
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


	@SafeVarargs    //from java 9 non-final private methods too
	private void goodVarargsMethod(List<String>... ls) {
		for (List<String> los : ls)
			System.out.println(los);
	}
}