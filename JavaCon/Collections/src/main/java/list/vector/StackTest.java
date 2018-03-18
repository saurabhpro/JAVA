/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.vector;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		stack.push(4);
		stack.push(22);
		stack.push(5);

		// show last element
		System.out.println(stack.peek());
	}
}
