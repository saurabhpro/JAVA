package sybex.ch08;

import java.io.File;

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
	}
}