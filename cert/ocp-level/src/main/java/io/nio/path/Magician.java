package io.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Magician {
	public static void main(String... cards) {
		final Magician m = new Magician();
		System.out.print(m.doTrick(
				Paths.get("/bag/of/tricks/.././disappear.txt")));
	}

	private String doTrick(Path path) {

		final Path path2 = path
				.subpath(2, 3);
		System.out.println(path2);

		return path2.getName(1)
				.toAbsolutePath()
				.toString();
	}
}