package io.basics;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Objects;

import static io.FilePaths.BASE_RELATIVE_PATH;

public class ReadFileInformation {
	public static void main(String[] args) {
		File file = new File(BASE_RELATIVE_PATH);
		System.out.println("File Exists: " + file.exists());

		if (file.exists()) {
			System.out.println("Absolute Path: " + file.getAbsolutePath());
			System.out.println("Is Directory: " + file.isDirectory());
			System.out.println("Parent Path: " + file.getParent());

			final LocalDateTime lastModified = LocalDateTime.ofEpochSecond(file.lastModified() / 1000, 0, ZoneOffset.ofHoursMinutes(5, 30));
			System.out.println("Last Modified: " + lastModified);

			System.out.println("File length: " + file.length());
			System.out.println("Path Contents: " + Arrays.toString(file.list()));

			if (file.isFile()) {
				System.out.println("File size: " + file.length());
				System.out.println("File LastModified: " + file.lastModified());
			} else {
				for (File subFile : Objects.requireNonNull(file.listFiles())) {
					System.out.println("\t" + subFile.getName());
				}
			}
		} else {
			final boolean dirCreated = file.mkdirs();
			System.out.println(file.exists());
		}
	}
}