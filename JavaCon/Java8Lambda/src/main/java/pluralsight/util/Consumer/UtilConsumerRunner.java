/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.util.Consumer;

import java.util.function.BiConsumer;

/**
 * Created by saurabhkumar on 21/05/17.
 */
public class UtilConsumerRunner {
	public static void main(String[] args) {
		java.util.function.Consumer<Integer> consumer = intger -> System.out.println(intger);//or System.out::println

		consumer.accept(55);
		consumer.andThen(consumer).accept(345);


		BiConsumer<Integer, String> consumer2 = (intger, name) -> System.out.println(intger + " of " + name); //not convertible to Method Refrence as arguments are modfied
		consumer2.accept(45, "Hi");
		consumer2.andThen(consumer2).accept(145, "Hioo");
	}
}
