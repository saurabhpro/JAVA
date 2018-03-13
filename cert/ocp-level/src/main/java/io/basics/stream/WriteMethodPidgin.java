package io.basics.stream;

import java.io.*;

/**
 * InputStream and OutputStream both support reading/writing byte arrays, making Option A incorrect.
 * While it is often recommended that an I/O array be a power of 2 for performance reasons, it is not required.
 * The key here is the write() method used does not take a length value, available in the chirps variable, when writing the file.
 * <p>
 * The method will always write the entire data array, even when only a handful of bytes were read into the data array,
 * which may occur during the last iteration of the loop.
 * The result is that files whose bytes are a multiple of 123 will be written correctly,
 * while all other files will be written with extra data appended to the end of the file. avnullnull etc.
 * <p>
 * If the write(data) call was replaced with write(data,0,chirps),
 * which does take the number of bytes read into consideration, then all files would copy correctly”
 */
public class WriteMethodPidgin {
	public void copyPidgin(File s, File t) throws Exception {
		try (InputStream is = new FileInputStream(s);
		     OutputStream os = new FileOutputStream(t)) {
			byte[] data = new byte[123];
			int chirps;
			while ((chirps = is.read(data)) > 0) {
				os.write(data);
			}
		}
	}
}