package io.basics;

import java.io.IOException;

class Read {
	public static void main(String[] args) {
		System.out.print("Type a character: ");
		int val = 0;

		try {
			// the return type of read is int, but it returns value between 0-255! Only the first character
			val = System.in.read();

		} catch (IOException ioe) {
			System.err.println("Cannot read input " + ioe);
			System.exit(-1);
		}
		System.out.println("You typed: " + val);
	}
}

/*
Output
Type a character: 0
You typed: 48
 */