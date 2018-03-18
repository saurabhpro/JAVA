/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package generics._8_advanced.b_intersection_types;

import generics._8_advanced.Person;

import java.io.*;

public class PersonReader {

	public static void main(String[] args) throws FileNotFoundException {

		String filePath = "/Users/saurabhkumar/GitHub/JAVA/JavaCon/Generics/src/main/resources/person.txt";

		PersonReader reader = new PersonReader();

		DataInputStream stream = new DataInputStream(new FileInputStream(filePath));
		Person person = reader.read(stream);
		System.out.println(person);

		RandomAccessFile randomAccess = new RandomAccessFile(filePath, "rw");
		person = reader.read(randomAccess);
		System.out.println(person);
	}

	private <T extends DataInput & Closeable> Person read(T source) {
		//effective final source - jdk9 improvement
		try (source) {
			return new Person(source.readUTF(), source.readInt());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
