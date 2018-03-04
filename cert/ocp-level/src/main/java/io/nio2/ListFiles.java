package io.nio2;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class ListFiles {
	public static void main(String[] args) throws IOException {

		// Files.list() method added in Java 8 to list all the files in the current directory
		try (Stream<Path> entries = Files.list(Paths.get("."))) {
			entries.forEach(System.out::println);
		}

		System.out.println("\nStreams");
		final Stream<Path> list = Files.list(Paths.get("."));
		list
				.map(path -> path.toAbsolutePath())
				.forEach(System.out::println);


		System.out.println("\nNew");
		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + "../../");
		Files.list(path)
				.filter(p -> !Files.isDirectory(p))
				.map(p -> p.toAbsolutePath())
				.forEach(System.out::println);


		System.out.println("\nWalking");
		// Note that the list() method does not recursively traverse the entries in the given Path.
		// To recursively traverse the directories, you can use the Files.walk() method:
		Files.walk(Paths.get("."))
				.limit(10)
				.forEach(System.out::println);

		// Walking with optional arguments
		long count = Files.walk(Paths.get("."), 6, FileVisitOption.FOLLOW_LINKS).count();
		System.out.println(count);
	}
}
