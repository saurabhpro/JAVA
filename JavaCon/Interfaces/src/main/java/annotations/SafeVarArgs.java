/*
 * Copyright (c) 2018 Saurabh Kumar
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
