package io.nio2.files.traverse;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;


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


		System.out.println("current dir path");
		Files.walk(Paths.get(".").toRealPath(), 0) // u1
				.map(p -> {
					try {
						return p.toRealPath();
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
				})
				.collect(Collectors.toList())
				.forEach(System.out::println);


		/*
		 * “Files.walk() does not follow symbolic links by default. For this reason, the cycle is never activated.
		 * If the FOLLOW_LINKS enum value was used in the call to Files.walk(), then it would trigger a cycle
		 * resulting in a FileSystemLoopException at runtime”
		 */
		try {
			System.out.print(Files.walk(Paths.get("/again/and/again")).count());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
