package io.basics;

import io.FilePaths;

import java.io.PrintStream;

class StreamTest {
	public static void main(String[] args) {
		try {
			PrintStream ps = new PrintStream(FilePaths.BASE_RELATIVE_PATH + "log.txt");
			System.setOut(ps);
			System.out.println("Test output to System.out again");
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
}
