/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package generics.diamond_op;

public class Java9DiamondOperatorWithAnonymousClass {
	public static void main(String[] args) {

		//Java 8 way
		//noinspection Convert2Diamond
		MyHandler<Integer> intHandler0 = new MyHandler<Integer>(0) {

			public void handle() {
				// handling code...
			}
		};
		intHandler0.handle();

		//from Java 9 we can use <> to infer the type
		MyHandler<Integer> intHandler = new MyHandler<>(1) {

			@Override
			public void handle() {
				System.out.println("handle > " + this.getContent());    //this here mean the context of anonymous class
			}
		};

		intHandler.handle();

		MyHandler<? extends Integer> intHandler1 = new MyHandler<>(10) {

			@Override
			void handle() {
				System.out.println("handle > " + getContent());
			}
		};

		intHandler1.handle();

		MyHandler<?> handler = new MyHandler<>("One hundred") {

			@Override
			void handle() {
				System.out.println("handle > " + getContent());
			}
		};

		handler.handle();
	}
}
