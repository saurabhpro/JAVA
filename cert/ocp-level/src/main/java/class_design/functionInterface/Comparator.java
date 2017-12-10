package class_design.functionInterface;

@FunctionalInterface
public interface Comparator<T> {
	int compare(T o1, T o2);

	// if you provide an abstract method from Object class in the interface, it still remains a functional interface.
	boolean equals(Object obj);
	// other methods are default methods or static methods and are elided
}

/*
- A derived interface can be a functional interface if it has only one abstract method or inherits only one abstract method.

- For a functional interface, declaring methods from Object class in an interface does not count as an abstract method.
 */