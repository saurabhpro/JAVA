package io.basics;

import io.FilePaths;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// A simple class to illustrate object streams: fill a data structure, write it to a
// temporary file and read it back and print the read data structure
class ObjectStreamExample {

	public static void main(String[] args) {
		Map<String, String> presidentsOfUS = new HashMap<>();

		presidentsOfUS.put("Barack Obama", "2009 to 2016, Democratic Party, 56th term");
		presidentsOfUS.put("George W. Bush", "2001 to 2009, Republican Party, 54th and 55th terms");
		presidentsOfUS.put("Bill Clinton", "1993 to 2001, Democratic Party, 52nd and 53rd terms");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FilePaths.BASE_RELATIVE_PATH + "object.data"))) {

			oos.writeObject(presidentsOfUS);

		} catch (FileNotFoundException fnfe) {
			System.err.println("cannot create a file with the given file name ");
		} catch (IOException ioe) {
			System.err.println("an I/O error occurred while processing the file");
		} // the ObjectOutputStream will auto-close, so don't have to worry about it

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FilePaths.BASE_RELATIVE_PATH + "object.data"))) {
			Object obj = ois.readObject();
			// first check if obj is of type Map
			if (obj != null && obj instanceof Map) {
				Map<?, ?> presidents = (Map<?, ?>) obj;
				System.out.println("President name \t Description");
				for (Map.Entry<?, ?> president : presidents.entrySet()) {
					System.out.printf("%s \t %s %n", president.getKey(), president.getValue());
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("cannot create a file with the given file name ");
		} catch (IOException ioe) {
			System.err.println("an I/O error occurred while processing the file");
		} catch (ClassNotFoundException cnfe) {
			System.err.println("cannot recognize the class of the object - is the file corrupted?");
		}
	}
}