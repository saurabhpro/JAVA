package io.nio2.files.traverse;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FindFiles {
	public static void main(String[] args) throws IOException {

		BiPredicate<Path, BasicFileAttributes> biPredicate =
				(path, attrs) -> attrs.isRegularFile() && path.toString().endsWith("class");


		// in find only 4th arg , FileVisitOption.FOLLOW_LINKS is optional
		try (Stream<Path> entries = Files.find(Paths.get("."), 6, biPredicate)) {
			entries.limit(100).forEach(System.out::println);
		}


		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + "../../");
		final long dateFilter = 1499070400000L;

		Stream<Path> stream = Files.find(
				path,
				4,
				(p, a) -> p.toString().endsWith(".java") && a.lastModifiedTime().toMillis() > dateFilter
		)
				.limit(5);

		stream.forEach(System.out::println);

		// Since we know that the top directory is regular and not a symbolic link,
		// no other paths will be visited and nothing will be printed.
		//Path path = Paths.get("/monkeys");
		Files.find(path, 0, (p, a) -> a.isSymbolicLink())
				.map(p -> p.toString()) // y1 0 meaning the only record that will be searched is the top- level directory.
				.collect(Collectors.toList()) // y2

				.stream() // y3
				.filter(x -> x.toString().endsWith(".txt")) // y4
				.forEach(System.out::println);


		final Path path2 = Paths.get(FilePaths.BASE_ABSOLUTE_PATH).resolve("../").normalize();
		System.out.println(path2);
		boolean myBoolean;
		try {
			myBoolean = Files.find(
					path,
					4,
					(Path p, BasicFileAttributes a) -> a.isDirectory() && !path2.equals(p)
			) // w1
					.findFirst()
					.isPresent();
			System.out.println(myBoolean ? "No Sub-directory" : "Has Sub-directory");


			myBoolean = Files.walk(path, 4)
					.filter((Path p) -> !path2.equals(p)) // w1
					.findFirst()
					.isPresent();
			System.out.println(myBoolean ? "No Sub-directory" : "Has Sub-directory");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}