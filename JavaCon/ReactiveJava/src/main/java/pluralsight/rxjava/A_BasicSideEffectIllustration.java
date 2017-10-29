/*
 * Copyright 2017 Saurabh Kumar 29/10/17 12:45 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.rxjava;

public class A_BasicSideEffectIllustration {

	private int state = 0;

	public static void main(String[] args) {

		A_BasicSideEffectIllustration v = new A_BasicSideEffectIllustration();

		// I can call the f1 method any number of times, with any number of threads
		// and I will always get the same answer so long as I provide the same
		// parameters because f1's result is totally determined by the incoming
		// parameters and nothing else.
		for (int i = 0; i < 100; i++) {
			if (v.f1(5) != 10) {
				throw new IllegalStateException();
			}
		}
		System.out.println("f1(5) = 10 for all calls");

		// If I call the f2 method, I can never be sure of what I'm going to
		// get because there is a side effect that effects the value returned.
		// If another thread or call somewhere else in the code gets to it
		// before I do, then the value will not be what I expect.
		for (int i = 0; i < 100; i++) {
			System.out.println("f2(5) = " + v.f2(5));
		}
	}

	/*
	 * Pure Functions which for a given argument returns predictable outcome - no matter thread or etc
	 */
	public int f1(int x) {
		return x * 2;
	}

	public int f2(int x) {
		state = (++state % 3);
		return x * 2 + state;
	}
}
