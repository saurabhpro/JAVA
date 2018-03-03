package io.nio2.files;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

class FileAttributes {
	public static void main(String[] args) {
		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + args[0]);
		try {
			Object object = Files.getAttribute(path, "creationTime", LinkOption.NOFOLLOW_LINKS);
			System.out.println("Creation time: " + object);

			object = Files.getAttribute(path, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
			System.out.println("Last modified time: " + object);

			object = Files.getAttribute(path, "size", LinkOption.NOFOLLOW_LINKS);
			System.out.println("Size: " + object + " bytes");

			// on Unix-y OS there is no "hidden property", but all files that start with a . are hidden by default.
			// object = Files.getAttribute(path, "dos:hidden", LinkOption.NOFOLLOW_LINKS); // window only
			// System.out.println("isHidden: " + object);

			object = Files.getAttribute(path, "isDirectory", LinkOption.NOFOLLOW_LINKS);
			System.out.println("isDirectory: " + object);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(Files.getLastModifiedTime(path).toMillis());

			Files.setLastModifiedTime(path, FileTime.fromMillis(System.currentTimeMillis()));

			System.out.println(Files.getLastModifiedTime(path).toMillis());
		} catch (IOException e) {
			// Handle file I/O exception...
		}
	}
}