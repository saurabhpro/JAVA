/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.whatsnew.demo04.langandlib.stream;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FindGitConflict {

	public static void main(String... args) throws Exception {

		// Files.lines -> Stream<String>
		Files.lines(Paths.get("resources/index.html"))
				.dropWhile(l -> !l.contains("<<<<<<<"))
				.skip(1)
				.takeWhile(l -> !l.contains(">>>>>>>"))
				.forEach(System.out::println);

	}


}
