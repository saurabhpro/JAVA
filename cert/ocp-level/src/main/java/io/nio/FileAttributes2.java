package io.nio;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

class FileAttributes2 {
	public static void main(String[] args) {
		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + args[0]);
		try {

			// the BasicFileAttributes interface defines the basic attributes supported by all common platforms.
			// However, specific platforms define their own file attributes, which are captured
			// by DosFileAttributes and PosixFileAttributes.
			// BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class); // works
			// BasicFileAttributes fileAttributes = Files.readAttributes(path, DosFileAttributes.class); // throws UnsupportedOperationException
			BasicFileAttributes fileAttributes = Files.readAttributes(path, PosixFileAttributes.class);

			System.out.println("File size: " + fileAttributes.size() + " bytes");
			System.out.println("isDirectory: " + fileAttributes.isDirectory());
			System.out.println("isRegularFile: " + fileAttributes.isRegularFile());
			System.out.println("isSymbolicLink: " + fileAttributes.isSymbolicLink());
			System.out.println("File last accessed time: " + fileAttributes.lastAccessTime());
			System.out.println("File last modified time: " + fileAttributes.lastModifiedTime());
			System.out.println("File creation time: " + fileAttributes.creationTime());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}