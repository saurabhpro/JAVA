package saurabh;

/**
 * Sealed classes and interfaces restrict/limit,
 * which other classes or interfaces may extend or implement them.
 */
// preview feature
public class SealedClassDemo {

	// special time of Abstract class
	public sealed class Animal
			permits Dog, Monkey, Leopard {
	}

	// this means the permitted classes have to be final and extend Animal

	final class Dog extends Animal {
		// does not allow extension
	}

	sealed class Monkey extends Animal permits OrangutanMonkey {
		// allows extension by Orangutan's only
	}

	public final class OrangutanMonkey extends Monkey {
		public int red, green, blue;
	}

	non-sealed class Leopard extends Animal {
		// basically open but cannot be base class for another non-sealed class
	}

	// non-sealed class LeopardsKid extends Leopard{} ERROR
	class LeopardsKid extends Leopard{} // ok


}
