package io.nio.operations;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Normalize {
	public static void main(String[] args) {
		Path path3 = Paths.get("/data");
		Path path4 = Paths.get("/user/home");

		Path relativePath = path3.relativize(path4);
		System.out.println(relativePath);

		System.out.println(path3.resolve(relativePath));

		// resolve this redundancy by applying the normalize()
		System.out.println(path3.resolve(relativePath).normalize());

	}
}
