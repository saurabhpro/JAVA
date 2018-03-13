package io.nio2.files.traverse;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// implements a simplified version of "type" command provided in Windows;
// given a text file name(s) as argument, it prints the content of the file(s)
public class FileLine {

	private static void processFile(String file) {
		try (Stream<String> lines = Files.lines(Paths.get(FilePaths.BASE_RELATIVE_PATH + file))) {
			lines.forEach(System.out::println);
		} catch (IOException ioe) {
			System.err.println("IOException occurred when reading the file... exiting");
			System.exit(-1);
		}
	}

	public static void main(String[] files) {
		files = new String[]{"log.txt"};

		if (files.length == 0) {
			System.err.println("pass the name of the file(s) as argument");
			System.exit(-1);
		}

		// process each file passed as argument
		Arrays.stream(files)
				.forEach(FileLine::processFile);


		more();
	}

	private static void more() {
		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + "log.txt");
		try {
			System.out.println("\nReading from Path: " + path.toRealPath());    //toAbsolutePath().normalize()
			final Stream<String> lines = Files.lines(path);
			lines.forEach(System.out::println); // UncheckedIOException on directory


			System.out.println("\nExtraFromStreams:" +
					Files.lines(path)
							.filter(s -> s.startsWith("WARN "))
							.map(s -> s.substring(5))
							.collect(Collectors.toList())
			);

		} catch (IOException e) {
			// Handle file I/O exception...
		}

		try {
			System.out.println("\nReadLines:");
			final List<String> lines = Files.readAllLines(path);
			lines.forEach(System.out::println);

		} catch (IOException e) {
			// Handle file I/O exception...
		}
	}
}