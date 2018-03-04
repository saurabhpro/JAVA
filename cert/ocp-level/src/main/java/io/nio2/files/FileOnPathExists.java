package io.nio2.files;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

// class to figure out whether a file/directory exists on the given path
public class FileOnPathExists {
	public static void main(String[] args) {
		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH);

		// LinkOption.NOFOLLOW_LINKS means that the Files.exists() method should not
		// follow symbolic links in the file system to determine if the path exists
		if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			System.out.println("The file/directory " + path.getFileName() + " exists");

			// check whether it is a file or a directory
			if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
				System.out.println(path.getFileName() + " is a directory");
			} else {
				System.out.println(path.getFileName() + " is a file");

				// check FilePermissions
				System.out.printf("Readable: %b, Writable: %b, Executable: %b \n",
						Files.isReadable(path), Files.isWritable(path), Files.isExecutable(path));
			}

		} else {
			System.out.println("The file/directory " + path.getFileName() + " does not exist");
		}

		// A root name is a directory, but path.getFileName() returns null if the path is a root name
		path = Paths.get("/");
		System.out.println(path.getFileName() + " is root a directory");

		if (Files.isDirectory(path) && Files.isSymbolicLink(path)) {
			try {
				Files.createDirectory(path.resolve("joey"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		final Path path2 = Paths.get(FilePaths.BASE_ABSOLUTE_PATH).resolve("../").normalize();
		System.out.println(path2);
		boolean myBoolean;
		try {
			myBoolean = Files.find(
					path,
					4,
					(Path p, BasicFileAttributes a) -> a.isDirectory() && !path2.equals(p)
			) // w1
					.findFirst()
					.isPresent();
			System.out.println(myBoolean ? "No Sub-directory" : "Has Sub-directory");


			myBoolean = Files.walk(path, 4)
					.filter((Path p) -> !path2.equals(p)) // w1
					.findFirst()
					.isPresent();
			System.out.println(myBoolean ? "No Sub-directory" : "Has Sub-directory");

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			if (Files.isSameFile(path, Paths.get("/zoo/turkey"))) // x1 NoSuchFileException since /zoo/turkey doesn't exist
				Files.createDirectory(path.resolve("info")); // x2
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}