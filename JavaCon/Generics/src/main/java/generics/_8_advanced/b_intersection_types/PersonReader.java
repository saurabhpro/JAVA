package generics._8_advanced.b_intersection_types;

import generics._8_advanced.Person;

import java.io.*;

public class PersonReader {
	public static void main(String[] args) throws FileNotFoundException {
		PersonReader reader = new PersonReader();

		DataInputStream stream = new DataInputStream(new FileInputStream("/Users/saurabhkumar/GitHub/JAVA/JavaCon/Generics/src/main/resources/person"));
		Person person = reader.read(stream);
		System.out.println(person);

		RandomAccessFile randomAccess = new RandomAccessFile("/Users/saurabhkumar/GitHub/JAVA/JavaCon/Generics/src/main/resources/person", "rw");
		person = reader.read(randomAccess);
		System.out.println(person);
	}

	private <T extends DataInput & Closeable> Person read(final T source) {
		try (T input = source) {
			return new Person(input.readUTF(), input.readInt());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
