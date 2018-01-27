package io.nio;

import io.FilePaths;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

// class to figure out whether a file/directory exists on the given path
class PathExists {
	public static void main(String[] args) {
		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + args[0]);

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
		System.out.println(path.getFileName() + " is a directory");
	}
}