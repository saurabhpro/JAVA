package io.basics;

import io.FilePaths;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileSample {
	public static void main(String[] args) {

		System.out.println(System.getProperty("file.separator"));
		System.out.println(java.io.File.separator);

		// type 1 constructor
		File file = new File("/home/smith/data/zoo.txt");
		System.out.println(file.exists());


		// type 2 constructor
		File parent = new File("/home/smith");
		File child = new File(parent, "data/zoo.txt");

		final File file1 = new File("c:/book/java");    // java fixes the path to correct slash
		System.out.println(file1.getAbsolutePath());

		final File file2 = new File("\\book\\java");    // java fixes the path to correct slash
		System.out.println(file2.getAbsolutePath());    // /Users/saurabhkumar/GitHub/JAVA/cert/ocp-level/\book\java


		File cake = new File("cake.txt");
		Writer pie;
		try {
			pie = new FileWriter(FilePaths.BASE_RELATIVE_PATH + "pie.txt");
			pie.write(65);
			pie.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		final boolean mkdirs = new File(FilePaths.BASE_RELATIVE_PATH + "fudge.txt").mkdirs();
	}
}