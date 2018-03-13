package io.nio.operations;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * basically jis path se relativize call ho rha hai -> wo argument wale path tak kasie phochega
 * conditions:
 * 1. either both absolute or both relative , mix will result in RuntimeException
 */
public class Relativize {

	public static void main(String[] args) {

		Path path01 = Paths.get("Topic.txt");
		Path path02 = Paths.get("Demo.txt");
		Path path03 = Paths.get("/Java/JavaFX/Topic.txt");
		Path path04 = Paths.get("/Java/2011");

		Path path01_to_path02 = path01.relativize(path02);
		System.out.println(path01_to_path02);

		Path path02_to_path01 = path02.relativize(path01);
		System.out.println(path02_to_path01);

		System.out.println();
		Path path03_to_path04 = path03.relativize(path04);
		System.out.println(path03_to_path04);
		/*
		in this case path3 -> Topic.txt wants to access path4 -> 2011 ->
		so
		../ JavaFx
		then ../Java and then 2011
		=> ../../2011
		 */

		Path path04_to_path03 = path04.relativize(path03);
		System.out.println(path04_to_path03);

		System.out.println();

		// both relative
		Path path1 = Paths.get("fish.txt");
		Path path2 = Paths.get("birds.txt");
		System.out.println(path1.relativize(path2));
		System.out.println(path2.relativize(path1));

		// both absolute
		Path path3 = Paths.get("/habitat");
		Path path4 = Paths.get("/sanctuary/raven");
		System.out.println(path3.relativize(path4));
		System.out.println(path4.relativize(path3));


		Path x = Paths.get(".", "song", "..", "/note");
		Path y = Paths.get("/dance/move.txt");
		x.normalize();
		System.out.println(x);
		System.out.println(x.resolve(y));
		System.out.println(y.relativize(x));
	}

}