package io.nio2.AttributeViews;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class BasicFileAttributesSample {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + "log.txt");
		BasicFileAttributes data = Files.readAttributes(path, BasicFileAttributes.class);

		System.out.println("Is path a directory? " + data.isDirectory());
		System.out.println("Is path a regular file? " + data.isRegularFile());
		System.out.println("Is path a symbolic link? " + data.isSymbolicLink());

		//  The isOther() method is used to check for paths that are not  les, directories, or symbolic links,
		// such as paths that refer to resources or devices in some file systems.
		System.out.println("Path not a file, directory, nor symbolic link? " + data.isOther());

		System.out.println("Size (in bytes): " + data.size());
		System.out.println("Creation date/time: " + data.creationTime());
		System.out.println("Last modified date/time: " + data.lastModifiedTime());
		System.out.println("Last accessed date/time: " + data.lastAccessTime());

		// he fileKey() method returns a  le system value that represents a unique identifier for the file within the
		// file system or null if it is not supported by the file system.
		System.out.println("Unique file identifier (if available): " + data.fileKey());
	}
}