package io.basics.stream;

import io.basics.ZebraMarkReset;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static io.FilePaths.BASE_RELATIVE_PATH;

class Animal {
	/*
	This serialVersionUID is stored with the serialized object and assists during the deserialization process.
	The serialization process uses the serialVersionUID to identify uniquely a version of the class.
	That way, it knows whether the serialized data for an object will match the instance variable in
	the current version of the class. If an older version of the class is encountered during deserialization,
	an exception may be thrown. Alternatively, some deserialization tools support conversions automatically.
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	private char type;

	Animal(String name, int age, char type) {
		this.name = name;
		this.age = age;
		this.type = type;
	}

	public Animal() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		System.out.println("Hey There from : " + stackTraceElements[3].getLineNumber());
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public char getType() {
		return type;
	}

	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
	}
}

class Animal2 extends Animal implements Serializable {
	private static final long serialVersionUID = 2L;
	private static char type = 'C';
	private transient String name;
	private transient int age = 10;
	private List<ZebraMarkReset> friends = new ArrayList<>();   // will be empty & not null


	{
		this.age = 14;
	}

	public Animal2() {
		this.name = "Unknown";
		this.age = 12;
		this.type = 'Q';
	}

	// Serialized Constructor are ignored from deserilaization until first Non-Serial Parent Class (no arg cons)
	public Animal2(String name, int age, char type) {
		this.name = name;
		this.age = age;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public char getType() {
		return type;
	}

	public String toString() {
		return "Animal2 [name=" + name + ", age=" + age + ", type=" + type + " List: " + friends + "]";
	}
}

/**
 * transient means the value won’t be included in the serialization process,
 * so it’s safe to assume name and age will be left out of the serialized file.
 * More interestingly, the values of age being set to 10, 12, or 14 in the class
 * are all ignored when the object is deserialized,
 * as no class constructor or default initializations are used
 */
public class ObjectStreamSerialSample {

	private static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
		List<Animal> animals = new ArrayList<>();

		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {

			while (true) {
				Object object = in.readObject();    // deserialize

				if (object instanceof Animal)
					animals.add((Animal) object);
			}
		} catch (EOFException ignored) {
			// File end reached
		}
		return animals;
	}

	private static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			for (Animal animal : animals)
				out.writeObject(animal);
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal2("Tommy Tiger", 5, 'T'));
		animals.add(new Animal2("Peter Penguin", 8, 'P'));

		File dataFile = new File(BASE_RELATIVE_PATH + "animal.data");

		createAnimalsFile(animals, dataFile);

		System.out.println(getAnimals(dataFile));
		//[Animal2 [name=null, age=0, type=P List: []], Animal2 [name=null, age=0, type=P List: []]]
	}
}