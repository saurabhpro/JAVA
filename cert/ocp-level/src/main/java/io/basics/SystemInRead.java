package io.basics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SystemInRead {
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

	private void echo() throws IOException {
		FileReader fileReader = new FileReader("zoo-data.txt");
		try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			System.out.println(bufferedReader.readLine());
		}
	}
}

/*
Output
Type a character: 0
You typed: 48
 */