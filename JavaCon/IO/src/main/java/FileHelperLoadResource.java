/*
 * Copyright (c) 2019 Saurabh Kumar
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class FileHelperLoadResource {

	public static void main(String[] args) throws IOException {

		FileHelperLoadResource main = new FileHelperLoadResource();
		File file = main.getFileFromResources("database.properties");

		printFile(file);
	}

	private static void printFile(File file) throws IOException {

		if (file == null) return;
/*
		try (FileReader reader = new FileReader(file);
		     BufferedReader br = new BufferedReader(reader)) {

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}

 */

		//Read File Content
		String content = new String(Files.readAllBytes(file.toPath()));
		System.out.println(content);
	}

	// get file from classpath, resources folder
	private File getFileFromResources(String fileName) {

		ClassLoader classLoader = getClass().getClassLoader();

		URL resource = classLoader.getResource(fileName);

		if (resource == null) {
			throw new IllegalArgumentException("file is not found!");
		} else {
			return new File(resource.getFile());
		}

	}
}
