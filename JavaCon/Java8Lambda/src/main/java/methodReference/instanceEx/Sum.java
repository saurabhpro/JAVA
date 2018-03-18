/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package methodReference.instanceEx;

/**
 * Created by saurabhkumar on 23/05/17.
 */
class Sum {
	public static void main(String[] args) {
		TriFunction<Sum, String, String, Integer> anon =
				new TriFunction<>() {
					@Override
					public Integer apply(Sum s, String arg1, String arg2) {
						return s.doSum(arg1, arg1);
					}
				};
		System.out.println(anon.apply(new Sum(), "1", "4"));

		//using a lambda expression:
		//TriFunction<Sum, String, String, Integer> lambda = (Sum s, String arg1, String arg2) -> s.doSum(arg1, arg1); OR
		TriFunction<Sum, String, String, Integer> lambda = (s, arg1, arg2) -> s.doSum(arg1, arg1);

		System.out.println(lambda.apply(new Sum(), "1", "4"));


		//by using a method reference:
		TriFunction<Sum, String, String, Integer> mRef = Sum::doSum;

		System.out.println(mRef.apply(new Sum(), "1", "4"));
	}

	private Integer doSum(String s1, String s2) {
		return Integer.parseInt(s1) + Integer.parseInt(s1);
	}
}