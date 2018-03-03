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
		final Path path21 = Paths.get("/tiger/cage");
		System.out.println(path11.resolve(path21));

		/*
		/cats/../panther/food
		/tiger/cage
		 */


	}
}
