package io.nio2;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

// implements a simplified version of "type" command provided in Windows;
// given a text file name(s) as argument, it prints the content of the file(s)
class Type {
	private static void processFile(String file) {
		try (Stream<String> lines = Files.lines(Paths.get(FilePaths.BASE_RELATIVE_PATH + file))) {
			lines.forEach(System.out::println);
		} catch (IOException ioe) {
			System.err.println("IOException occurred when reading the file... exiting");
			System.exit(-1);
		}
	}

	public static void main(String[] files) {
		if (files.length == 0) {
			System.err.println("pass the name of the file(s) as argument");
			System.exit(-1);
		}

		// process each file passed as argument
		Arrays.stream(files)
				.forEach(Type::processFile);
	}
}