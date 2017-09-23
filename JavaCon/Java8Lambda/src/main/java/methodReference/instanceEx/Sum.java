/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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