package io.nio2.files;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileMove {
	public static void main(String[] args) {
		args = new String[]{FilePaths.BASE_RELATIVE_PATH, FilePaths.BASE_RELATIVE_PATH};
		if (args.length != 2) {
			System.out.println("usage: FileMove <source-path> <destination-path>");
			System.exit(-1);
		}
		Path pathSource = Paths.get(args[0]);
		Path pathDestination = Paths.get(args[1]);
		try {
			Files.move(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);

			/* You can specify move() as an atomic operation using the ATOMIC_MOVE copy option.
			When you specify an atomic move, you are assured that either the move completes successfully
			or the source continues to be present. If move() is performed as a non-atomic operation
			and it fails while in process, the state of both files is unknown and undefined.
			 */
			System.out.println("Source file moved successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}


		try {
			Files.move(Paths.get(FilePaths.BASE_RELATIVE_PATH + "/zoo"), Paths.get(FilePaths.BASE_RELATIVE_PATH + "/zoo-new"));
			Files.move(Paths.get(FilePaths.BASE_RELATIVE_PATH + "log.txt"), Paths.get(FilePaths.BASE_RELATIVE_PATH + "zoo-new/log.txt"));
		} catch (IOException e) {
// Handle file I/O exception...
		}
	}
}