/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package methodReference.staticEx;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * Created by saurabhkumar on 23/05/17.
 */
interface NumbersO {
	static boolean isMoreThanFifty(int n1, int n2) {
		return (n1 + n2) > 50;
	}

	static List<Integer> findNumbers(
			List<Integer> l, BiPredicate<Integer, Integer> p) {
		List<Integer> newList = new ArrayList<>();
		for (Integer i : l) {
			if (p.test(i, i + 10)) {
				newList.add(i);
			}
		}
		return newList;
	}
}
