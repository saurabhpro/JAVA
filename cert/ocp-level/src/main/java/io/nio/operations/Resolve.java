package io.nio.operations;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * resolve means define a new path to reach the argument path
 * 1. if path2 is relative obviously you will have to just access it from your current path
 * 2. if path2 is absolute -> simply accessing itself will work
 */
public class Resolve {
	public static void main(String[] args) {
		final Path path1 = Paths.get("/cats/../panther");
		final Path path2 = Paths.get("food");
		System.out.println(path1.resolve(path2));


		final Path path11 = Paths.get("/turkey/food");
		final Path path21 = Paths.get("/tiger/cage");   // path 2 is absolute to it is the answer
		System.out.println(path11.resolve(path21));

		/*
		/cats/../panther/food
		/tiger/cage
		 */


		Path path10 = Paths.get("/pets/../cat.txt");
		Path path12 = Paths.get("./dog.txt");
		System.out.println(path10.resolve(path12));
		System.out.println(path12.resolve(path10));
	}
}

class Surgeon {
	public static void main(String... tools) {
		final Surgeon al = new Surgeon();
		Path original = Paths.get("/tissue/heart/chambers.txt");
		Path repaired = al.rebuild(original);
		System.out.println(original);
		System.out.println(repaired);
		System.out.print(original.equals(repaired));
	}

	private Path rebuild(Path p) {
		Path v = null;
		for (int i = 0; i < p.getNameCount(); i++)
			if (v == null) v = p.getName(i);
			else v = v.resolve(p.getName(i));
		return v;
	}
}

class Sun {
	public static void main(String... emerald) {
		Sun s = new Sun();
		s.printInfo();
	}

	private void printInfo() {
		Path halleysComet = Paths.get("stars/./rocks/../m1.meteor").normalize();
		System.out.println(halleysComet);
		Path lexellsComet = Paths.get("./stars/../solar/");

		lexellsComet = lexellsComet.subpath(0, 2)
				.resolve("m1.meteor")
				.normalize();
		System.out.println(lexellsComet);

		System.out.print(halleysComet.equals(lexellsComet)
				? "Same!" : "Different!");
	}
}