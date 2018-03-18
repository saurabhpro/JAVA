/*
 * Copyright (c) 2018 Saurabh Kumar
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
