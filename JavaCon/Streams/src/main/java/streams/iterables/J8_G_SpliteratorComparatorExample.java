/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.iterables;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeSet;

public class J8_G_SpliteratorComparatorExample {
	public static void main(String[] args) {
		SortedSet<Test> set = new TreeSet<>(Comparator.comparing(o -> o.str));

		set.add(new Test("two"));
		set.add(new Test("one"));

		Spliterator<Test> s = set.spliterator();

		System.out.println(s.getComparator());
		System.out.println(set);
	}

	private static class Test {
		private final String str;

		private Test(String str) {
			this.str = str;
		}

		@Override
		public String toString() {
			return "Test{str='" + str + "'}";
		}
	}
}