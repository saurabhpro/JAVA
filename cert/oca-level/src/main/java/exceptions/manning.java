package exceptions;

public class manning {

	public static void main(String[] args) {
		try {
			String[][] names = {{"Andre", "Mike"}, null, {"Pedro"}};
			System.out.println(names[2][1].substring(0, 2));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(1);
		}
	}


}


class ExceptionFun {
	public ExceptionFun(Object obj) {
		//while (true){}

		if (obj == null)
			throw new IllegalArgumentException("Provide an object!");
		System.out.println(obj + " created!");
	}

	public static void createObject() {
		try {
			ExceptionFun obj = new ExceptionFun(null);
		} finally {
			System.out.println("Was the object created?");
		}
	}

	public static void main(String[] args) {
		createObject();
	}
}

/*
Invariant fields are those fields whose values are integral to object state and should be constrained within an acceptable range. The invariant field, and all fields on which it depends, must be protected from direct manipulation. In this scenario, the value for the handValue field is dependent on the cards field, so both fields should be declared as private to prevent direct access from outside the class. Accessors and mutator methods provide indirect access to variants, so that the class is functional. The getVal method is an accessor that should be accessible outside of the class. Although the modifier does not need to be public, the private modifier is too restrictive to be functional.

Encapsulation hides the inner workings of an object and only presents the object's methods as a means to using it. For example, if there is an object of the class Car, the user of the object should be able to access functions like start(), accelerate(), changeGear(), brake(), etc. without needing to know how these are implemented internally. This "encapsulates" the functionality required of a Car through an interface provided by the methods of the Car.

Encapsulation has many benefits, including:

    Reusing code: You can simply access the methods exposed by a pre-written class without having to write a new class of your own.
    Maintenance: You can trouble shoot problematic code and simply fix objects that are causing the problem without affecting the rest of the code of the program.
    Protecting code: By using the methods of an object, the user will never know how it was actually implemented or be able to modify the members of the class directly.
    Object independence: Keeping blocks of code as objects makes the program more robust and flexible allowing objects to be moved around in the program and replaced if required without affecting the rest of the program.

If the handValue field is invariant, then both the handValue field and the cards field should be declared with the modifier private. The invariant field and all fields on which it depends must be protected from direct manipulation. Because the value for the handValue field is dependent on the cards field, the handValue field should be declared as private as well.

If the handValue field is invariant, then the constructor should not be declared with the modifier private. Declaring the constructor with the private modifier is only required to prevent class instantiation, not protect invariant fields.


The object type determines which implementation is executed for overridden methods.
A method is overridden when a subclass method has the same method signature as a method in the superclass.
The JVM chooses which method is executed based on the instantiated class, not the variable reference type.
This is known as polymorphism or virtual method invocation in Java.

The reference type does not correspond to the instantiated class.
The reference type corresponds to the type in the variable declaration.

The object type does not correspond to the class in the variable declaration. The object type corresponds to the instantiated class.

The reference type does not determine which implementation is executed for overloaded methods.
The argument data types and their order determine which implementation is executed.
A method is overloaded when another method within the same class or subclass has the same name, but different signatures.
The object type does not determine the version of the overloaded method.

 */