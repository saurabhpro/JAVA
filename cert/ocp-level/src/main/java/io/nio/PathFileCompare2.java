package io.nio;

import io.FilePaths;

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
	}
}