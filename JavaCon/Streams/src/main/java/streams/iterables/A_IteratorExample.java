/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.iterables;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class A_IteratorExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Apple", "Banana", "Orange");
		//noinspection ForLoopReplaceableByForEach
		for (Iterator<String> i = list.iterator(); i.hasNext(); )
			System.out.println(i.next());
	}
}