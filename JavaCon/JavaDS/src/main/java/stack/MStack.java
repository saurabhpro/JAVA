/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package stack;

public class MStack<T> {
	private static final int MAX = 100;

	private int topIndex;
	private T internalArray[];

	@SuppressWarnings("unchecked")
	MStack() {
		topIndex = -1;
		internalArray = (T[]) new Object[MAX]; // Maximum size of Stack
	}

	boolean isEmpty() {
		return (topIndex < 0);
	}

	boolean push(T x) {
		if (topIndex >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			internalArray[++topIndex] = x;
			System.out.println(x + " pushed into stack");
			return true;
		}
	}

	T pop() {
		if (topIndex < 0) {
			System.out.println("Stack Underflow");
			throw new ArrayIndexOutOfBoundsException(topIndex);
		} else {
			return internalArray[topIndex--];
		}
	}
}
