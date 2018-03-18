/*
 * Copyright (c) 2018 Saurabh Kumar
 */

public class TheObjectInheritanceConundrum {
	/*
	 * In Java, all classes inherit from the Object class directly or indirectly.
	 * Therefore, there is always a single inheritance tree of classes in Java,
	 * and Object class is root of the tree.
	 *
	 * In Java, if we create a class that doesn’t inherit from any class then it automatically inherits from Object class .
	 */
}


class MyLifeMyChoices extends TheObjectInheritanceConundrum {
	/*
	 * You would think this class extends two classes Object + TheObjectInheritanceConundrum
	 * But no!
	 *
	 * As written above this is an example of classic INDIRECT inheritance to Object inheritance
	 *
	 * So for MyLifeMyChoice its only extending TheObjectInheritanceConundrum which does the Object thingy
	 */
}