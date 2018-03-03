package io.nio2.files;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileWalk {
	public static void main(String[] args) {
		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + "../../");
		try {

			// traverses in depth first and lazy manner - load subdirectory content only when subdirectory is reached
//			Files.walk(path)
//					.filter(p -> p.toString().endsWith(".java"))
//					.forEach(p -> System.out.println(p.normalize()));

			Files.walk(path, 4)
					.filter(p -> p.toString().endsWith(".java"))
					.forEach(p -> System.out.println(p.normalize()));

		} catch (IOException e) {
			// Handle file I/O exception...
			System.err.println("some problem");
		}

		final long dateFilter = 1499070400000L;
		try {
			Stream<Path> stream = Files.find(
					path,
					10,
					(p, a) -> p.toString().endsWith(".java") && a.lastModifiedTime().toMillis() > dateFilter
			);

			stream.forEach(System.out::println);

		} catch (Exception e) {
			// Handle file I/O exception...
			System.err.println("some problem");
		}


		try {
			Files.list(path)
					.filter(p -> !Files.isDirectory(p))
					.map(p -> p.toAbsolutePath())
					.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("some problem");
		}
	}
}
