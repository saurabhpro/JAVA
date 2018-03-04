package io.basics;

import io.FilePaths;

import java.io.*;

public class PrintTest {
	public static void main(String[] args) {
		try {
			PrintStream ps = new PrintStream(FilePaths.BASE_RELATIVE_PATH + "log.txt");
			System.setOut(ps);
			System.out.println("Test output to System.out again");
		} catch (Exception ee) {
			ee.printStackTrace();
		}


		PrintWriter out;
		try {
			out = new PrintWriter("zoo.log");

			out.print(5); // PrintWriter method
			out.write(3); // Writer method
			out.print(6.0); // PrintWriter method
			out.write(String.valueOf(2.0)); // Writer method
			out.println(String.valueOf(8.0)); // PrintWriter method
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String line;
		Console c = System.console();
		Writer w = c.writer();
		if ((line = c.readLine()) != null) {
			try {
				w.append(line);
				w.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}
}
