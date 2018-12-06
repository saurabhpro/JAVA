/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MStackTest {

	@DisplayName("push pop")
	@Test
	void main() {
		var s = new MStack<Integer>();

		s.push(10);
		s.push(20);
		s.push(30);

		System.out.println();

		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println(s.pop() + " Popped from stack");
	}

	@DisplayName("pop underflow")
	@Test
	void popEx() {
		var s = new MStack<Integer>();

		s.push(10);
		System.out.println(s.pop() + " Popped from stack");

		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, s::pop);
	}
}