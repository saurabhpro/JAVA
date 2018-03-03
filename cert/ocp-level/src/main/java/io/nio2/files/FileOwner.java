package io.nio2.files;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

public class FileOwner {
	public static void main(String[] args) {
		try {
			// Read owner of file
			Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + "log.txt");
			System.out.println(Files.getOwner(path).getName());

			// Change owner of file
			UserPrincipal owner = path
					.getFileSystem()
					.getUserPrincipalLookupService()
					.lookupPrincipalByName("saurabhkumar");  // needs exact name of the user - saurabhkumar

			System.out.println(owner);
			Files.setOwner(path, owner);

			// Output the updated owner information
			System.out.println(Files.getOwner(path).getName());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
