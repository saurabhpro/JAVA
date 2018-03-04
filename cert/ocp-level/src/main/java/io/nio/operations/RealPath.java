package io.nio.operations;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class RealPath {
	public static void main(String[] args) throws IOException {
		try {
			System.out.println(Paths.get("/zebra/food.source").toRealPath());
			System.out.println(Paths.get(".././food.txt").toRealPath());
		} catch (IOException e) {
			// Handle file I/O exception...
			System.err.println("Path doesn't exist");
		}


		// only method that takes LinkOption as an argument
		System.out.println(Paths.get(".").toRealPath(LinkOption.NOFOLLOW_LINKS));
		// /Users/saurabhkumar/GitHub/JAVA/cert/ocp-level


		System.out.println(Paths.get(".").toAbsolutePath());
		// System.out.println(Paths.get(".").normalize().toAbsolutePath());
		//however the toAbsolutePath() returns /Users/saurabhkumar/GitHub/JAVA/cert/ocp-level/.
	}
}
