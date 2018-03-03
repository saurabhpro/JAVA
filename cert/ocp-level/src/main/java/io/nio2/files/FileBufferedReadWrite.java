package io.nio2.files;

import io.FilePaths;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileBufferedReadWrite {
	public static void main(String[] args) {
		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + "log.txt");
		try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("US-ASCII"))) {
			// Read from the stream
			String currentLine;
			while ((currentLine = reader.readLine()) != null)
				System.out.println(currentLine);
		} catch (IOException e) {
			// Handle file I/O exception...
			System.err.println("problem with reading");
		}


		List<String> data = new ArrayList<>();
		try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("US-ASCII"))) {
			writer.write("Test output to System.out again\nHello World");   // overwrites file if it exists
		} catch (IOException e) {
			// Handle file I/O exception...
			System.err.println("Problem");
		}


		try {
			final List<String> lines = Files.readAllLines(path, Charset.forName("US-ASCII"));
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// Handle file I/O exception...
		}
	}
}
