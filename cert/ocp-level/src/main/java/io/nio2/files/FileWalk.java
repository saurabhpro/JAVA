package io.nio2.files;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWalk {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + "../../");

		// traverses in depth first and lazy manner - load subdirectory content only when subdirectory is reached
//			Files.walk(path)
//					.filter(p -> p.toString().endsWith(".java"))
//					.forEach(p -> System.out.println(p.normalize()));

		Files.walk(path, 4)
				.filter(p -> p.toString().endsWith(".java"))
				.forEach(p -> System.out.println(p.normalize()));

		System.out.println("\n\n");
		System.out.println(Paths.get(".").toAbsolutePath());
		System.out.println(Paths.get(".").toRealPath());
		System.out.println(Paths.get("..").getParent());
		System.out.println(Paths.get("..").toAbsolutePath());
		System.out.println(Paths.get("..").toAbsolutePath().getParent());
		System.out.println(Paths.get("..").toRealPath());   // = .toAbsolutePath().normalize()
		System.out.println(Paths.get("..").toRealPath().getParent());
		/*

/Users/saurabhkumar/GitHub/JAVA/cert/ocp-level/.
/Users/saurabhkumar/GitHub/JAVA/cert/ocp-level
null
/Users/saurabhkumar/GitHub/JAVA/cert/ocp-level/..
/Users/saurabhkumar/GitHub/JAVA/cert/ocp-level
/Users/saurabhkumar/GitHub/JAVA/cert
/Users/saurabhkumar/GitHub/JAVA
		 */
		System.out.println("\n");
		Files.walk(Paths.get("..").toRealPath().getParent()) // u1
				.map(p -> p.toAbsolutePath().toString()) // u2
				.filter(s -> s.endsWith(".java")) // u3
				.limit(5)
				.collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("\n\n");

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
		Files.find(path, 0, (p, a) -> a.isSymbolicLink()).map(p -> p.toString()) // y1 0 meaning the only record that will be searched is the top- level directory.
				.collect(Collectors.toList()) // y2
				.stream() // y3
				.filter(x -> x.toString().endsWith(".txt")) // y4
				.forEach(System.out::println);

	}
}
