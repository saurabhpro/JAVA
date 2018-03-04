package io.basics.stream;

import io.FilePaths;

import java.io.*;

public class CopyFileStreamSample {

	/*
	private static void copy(File source, File destination) throws IOException {
		try (InputStream in = new FileInputStream(source);
		     OutputStream out = new FileOutputStream(destination)) {

			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
		}
	}

	*/

	private static void copy(File source, File destination) throws IOException {
		try (
				InputStream in = new BufferedInputStream(new FileInputStream(source));
				OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))
		) {

			byte[] buffer = new byte[1024];
			int lengthRead;

			while ((lengthRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		File source = new File(FilePaths.BASE_RELATIVE_PATH + "log.txt");
		File destination = new File(FilePaths.BASE_RELATIVE_PATH + "log_copy.txt");

		copy(source, destination);
	}
}