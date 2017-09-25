/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
