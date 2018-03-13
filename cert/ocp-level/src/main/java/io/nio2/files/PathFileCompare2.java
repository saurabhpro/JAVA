package io.nio2.files;

import io.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// illustrates how to use Files class to compare two paths
public class PathFileCompare2 {
	public static void main(String[] args) throws IOException {
		// directories must exist
		Path path1 = Paths.get(FilePaths.BASE_RELATIVE_PATH);
		Path path2 = Paths.get(FilePaths.BASE_ABSOLUTE_PATH);

		System.out.println("Files.isSameFile(path1, path2) is: " + Files.isSameFile(path1, path2));

		one();


		try {
			if (Files.isSameFile(path1, Paths.get("/zoo/turkey"))) // x1 NoSuchFileException since /zoo/turkey doesn't exist
				Files.createDirectory(path1.resolve("info")); // x2
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void one() throws IOException {
		Path path1 = Paths.get("/lizard/./").resolve(Paths.get("walking.txt"));
		Path path2 = new File("/lizard/././actions/../walking.txt").toPath();

		System.out.println(path1 + "\n" + path2);
		System.out.print(Files.isSameFile(path1, path2));
		System.out.print(" " + path1.equals(path2));
		System.out.print(" " + path1.normalize().equals(path2.normalize()));
	}
}