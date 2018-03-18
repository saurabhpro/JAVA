/*
 * Copyright (c) 2018 Saurabh Kumar
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
