package io.nio2.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Road {
	public static void main(String... emerald) {
		System.out.print("AM I HOME? "
				+ (new Road().findHome() ? "yes" : " no"));
	}

	private boolean findHome() {
		Path oftenTraveled = Paths.get("/highway/street/spot.txt");
		Path lessTraveled = Paths.get("/highway/street/house/../.");
		lessTraveled.resolve("spot.txt");
		System.out.println(lessTraveled.resolve("spot.txt"));
		System.out.println(lessTraveled.normalize());
		return oftenTraveled.equals(lessTraveled.normalize());
	}

}

class Snow {
	public static boolean removeSnow(Path flake) throws IOException {
		if (!Files.isDirectory(flake) && !Files.isSymbolicLink(flake))
			return Files.deleteIfExists(flake);
		else return true;
	}

	public static void main(String[] cones) throws IOException {
		File driveway = new File("/driveway");
		for (File f : driveway.listFiles()) {
			System.out.println(removeSnow(f.toPath()));
		}
	}
}