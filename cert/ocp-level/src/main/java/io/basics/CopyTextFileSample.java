package io.basics;

import io.FilePaths;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CopyTextFileSample {

	private static List<String> readFile(File source) throws IOException {
		List<String> data = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
			String s;

			while ((s = reader.readLine()) != null) {
				data.add(s);
			}
		}
		return data;
	}

	private static void writeFile(List<String> data, File destination) throws IOException {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

			for (String s : data) {
				writer.write(s);
				writer.newLine();   // insert a line break
			}
		}
	}

	public static void main(String[] args) throws IOException {
		File source = new File(FilePaths.BASE_RELATIVE_PATH + "log.txt");
		File destination = new File(FilePaths.BASE_RELATIVE_PATH + "log_copy.txt");

		if (source.exists()) {
			List<String> data = readFile(source);

			data.forEach(System.out::println);

			writeFile(data, destination);

			if (destination.exists())
				System.out.println("copied file created!");

		}

		Charset usAsciiCharset = Charset.forName("US-ASCII");
		Charset utf8Charset = Charset.forName("UTF-8");
		Charset utf16Charset = Charset.forName("UTF-16");
	}
}