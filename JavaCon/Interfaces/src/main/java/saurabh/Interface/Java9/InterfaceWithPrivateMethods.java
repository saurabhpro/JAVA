/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Interface.Java9;

@SuppressWarnings("ALL")
@FunctionalInterface
interface InterfaceWithPrivateMethods {

	private static String staticPrivate() {
		return "static private";
	}

	static void checkThis() {
		//approach 1
		String result = staticPrivate();
		System.out.println(result);

		//approach 2
		// anonymous class
		InterfaceWithPrivateMethods pvt = () -> {  /*just to show what we want to do*/ };
		result = pvt.instancePrivate();
		System.out.println(result);

		//approach 3 - doesn't work obv
		/*result = instancePrivate();
		System.out.println(result);*/
	}

	private String instancePrivate() {
		return "instance private";
	}

	default void check() {
		//approach 1
		String result = staticPrivate();
		System.out.println(result);

		//approach 2
		//noinspection Convert2Lambda
		InterfaceWithPrivateMethods pvt = new InterfaceWithPrivateMethods() {
			@Override
			public void thisOneMakeItFI() {
				//just to show what we want to do
			}
			// anonymous class
		};
		result = pvt.instancePrivate();
		System.out.println(result);

		//approach 3
		result = instancePrivate();
		System.out.println(result);
	}

	void thisOneMakeItFI();
}

class Tester implements InterfaceWithPrivateMethods {

	public static void main(String[] args) {
		Tester tester = new Tester();
		tester.thisOneMakeItFI();
		tester.check();

		//Tester.checkThis(); is not possible
		InterfaceWithPrivateMethods.checkThis();
	}

	@Override
	public void thisOneMakeItFI() {
		System.out.println("Lonely implementation");
	}
}