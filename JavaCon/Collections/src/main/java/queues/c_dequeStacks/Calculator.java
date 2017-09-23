/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package queues.c_dequeStacks;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

import static java.lang.Integer.parseInt;

class Calculator {

    /*
    1
    -
    3
    +
    2
    +
    4
    */

	int evaluate(final String input) {
		final Deque<String> stack = new ArrayDeque<>();
		final String[] tokens = input.split(" ");

		/*for (String token : tokens) {
			stack.add(token);
		}

		//no need to add tokens one by one, as we already have a list we can simple use Collections.addAll(collection, list)

		*/

		Collections.addAll(stack, tokens);


		while (stack.size() > 1) {
			final int left = parseInt(stack.pop());
			final String operator = stack.pop();
			final int right = parseInt(stack.pop());

			int result = 0;
			switch (operator) {
				case "+":
					result = left + right;
					break;

				case "-":
					result = left - right;
					break;
			}

			stack.push(String.valueOf(result));
		}

		return parseInt(stack.pop());
	}
}
