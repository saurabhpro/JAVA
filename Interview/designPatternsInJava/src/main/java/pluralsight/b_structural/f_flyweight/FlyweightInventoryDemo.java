/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.b_structural.f_flyweight;

public class FlyweightInventoryDemo {

	public static void main(String[] args) {
		InventorySystem ims = new InventorySystem();

		ims.takeOrder("Roomba", 221);
		ims.takeOrder("Bose Headphones", 361);
		ims.takeOrder("Samsung TV", 432);
		ims.takeOrder("Samsung TV", 323);
		ims.takeOrder("Roomba", 563);
		ims.takeOrder("Bose Headphones", 321);
		ims.takeOrder("Roomba", 234);
		ims.takeOrder("Samsung TV", 54);
		ims.takeOrder("Roomba", 34);
		ims.takeOrder("Bose Headphones", 365);
		ims.takeOrder("Samsung TV", 332);
		ims.takeOrder("Roomba", 456);

		ims.process();

		System.out.println(ims.report());

	}
}
