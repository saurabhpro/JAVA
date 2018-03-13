package io.nio.path;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

// To illustrate important methods such as normalize(), toAbsolutePath(), and toRealPath()
public class PathInfo {

	public static void main(String[] args) throws IOException {

		// get a path object with relative path
		Path testFilePath = Paths.get(FilePaths.BASE_RELATIVE_PATH);
		System.out.println("The file name is: " + testFilePath.getFileName());
		System.out.println("Its URI is: " + testFilePath.toUri());
		System.out.println("Its absolute path is: " + testFilePath.toAbsolutePath());
		System.out.println("Its normalized path is: " + testFilePath.normalize() + "\n");

		// get another path object with normalized relative path
		Path testPathNormalized = Paths.get(testFilePath.normalize().toString());
		System.out.println("Its normalized absolute path is: " + testPathNormalized.toAbsolutePath());
		System.out.println("Its normalized real path is: " + testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS)); // throws exception if path doesn't exist

		//This resolve() method considers the given path to be a directory and joins (resolves) the passed path with it
		Path resolvedPath = testFilePath.resolve("Test");
		System.out.println(resolvedPath);   // OUTPUT = ./src/main/java/io/bin/Test
	}
}
