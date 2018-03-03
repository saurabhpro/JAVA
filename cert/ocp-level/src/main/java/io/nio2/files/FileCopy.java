package io.nio2.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopy {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("usage: FileMove <source-path> <destination-path>");
			System.exit(-1);
		}
		Path pathSource = Paths.get(args[0]);
		Path pathDestination = Paths.get(args[1]);
		try {
			Files.copy(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);

			/* You can specify move() as an atomic operation using the ATOMIC_MOVE copy option.
			When you specify an atomic move, you are assured that either the move completes successfully
			or the source continues to be present. If move() is performed as a non-atomic operation
			and it fails while in process, the state of both files is unknown and undefined.
			 */
			System.out.println("Source file moved successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}


		try (InputStream is = new FileInputStream("source-data.txt");
		     OutputStream out = new FileOutputStream("output-data.txt")) { // Copy stream data to file
			Files.copy(is, Paths.get("c:\\mammals\\wolf.txt"));
			// Copy file data to stream
			Files.copy(Paths.get("c:\\fish\\clown.xsl"), out);
		} catch (IOException e) {
			// Handle file I/O exception... }
		}
	}
}