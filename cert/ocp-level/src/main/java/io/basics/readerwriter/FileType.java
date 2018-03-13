package io.basics.readerwriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static io.FilePaths.BASE_RELATIVE_PATH;

// implements a simplified version of "type" command provided in Windows given
// a text file name(s) as argument, it prints the content of the text file(s) on console
public class FileType {

	public static void main(String[] files) {

		if (files.length == 0) {
			files = new String[]{"log.txt"};
			// System.err.println("pass the name of the file(s) as argument");
			// System.exit(-1);
		}
		// process each file passed as argument
		for (String file : files) {

			// try opening the file with FileReader
			try (FileReader inputFile = new FileReader(BASE_RELATIVE_PATH + file)) {

				int ch;

				// while there are characters to fetch, read, and print the
				// characters when EOF is reached, read() will return -1,
				// terminating the loop
				while ((ch = inputFile.read()) != -1) {
					// ch is of type int - convert it back to char before printing
					System.out.print((char) ch);
				}

			} catch (FileNotFoundException fnfe) {
				// the passed file is not found ...
				System.err.printf("Cannot open the given file %s ", file);
			} catch (IOException ioe) {
				// some IO error occurred when reading the file ...
				System.err.printf("Error when processing file %s... skipping it", file);
			}
			// try-with-resources will automatically release FileReader object
		}
	}
}