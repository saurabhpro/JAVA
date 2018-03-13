package io.basics.readerwriter;

import io.FilePaths;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class HighStreamCloseFurniture {
	public final static void main(String... inventory) throws Exception {

		Writer w = new FileWriter(FilePaths.BASE_RELATIVE_PATH + "couch.txt");

		try (BufferedWriter bw = new BufferedWriter(w)) {
			bw.write("Blue coach on Sale!");
		} finally {
			// the BufferedWriter calls close() before executing any associated catch or finally blocks.
			// Since closing a high-level stream automatically closes the associated low-level stream,
			// the w object is already closed by the time the finally block is executed.

			w.flush();  // java.io.IOException: Stream closed
			w.close();
		}
		System.out.print("Done!");
	}
}