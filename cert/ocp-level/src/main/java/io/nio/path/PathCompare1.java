package io.nio.path;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// illustrates how to use compareTo and equals and also shows
// the difference between the two methods
class PathCompare1 {
	public static void main(String[] args) {
		Path path1 = Paths.get("Test");
		Path path2 = Paths.get(FilePaths.BASE_LOCATION + "Test");

		// comparing two paths using compareTo() method
		System.out.println("(path1.compareTo(path2) == 0) is: " + (path1.compareTo(path2) == 0));

		// comparing two paths using equals() method
		System.out.println("path1.equals(path2) is: " + path1.equals(path2));

		// comparing two paths using equals() method with absolute path
		System.out.println("path2.equals(path1.toAbsolutePath()) is " + path2.equals(path1.toAbsolutePath()));

		/*
		even if two Path objects point to the same file/directory,
		it is not guaranteed that the equals() method will return true.

		You need to make sure both are absolute and normalized paths for an equality comparison to succeed for paths.
		 */


		Path t1 = Paths.get("/sky/.././stars.exe");
		Path t2 = Paths.get("/stars.exe");
		Path t3 = t1.resolve(t2);
		boolean b1 = t1.equals(t2);
		boolean b2 = t1.normalize().equals(t2);
		boolean b3 = false;
		boolean b4 = false;

		try {
			b3 = Files.isSameFile(t1.normalize(), t2);
			System.out.println(t2 + " M " + t3);
			b4 = Files.isSameFile(t2, t3);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(b1 + "," + b2 + "," + b3 + "," + b4);
	}
}
