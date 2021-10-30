package saurabh.j16;

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
    }

    final class Monkey extends Animal {
    }

    final class Leopard extends Animal {
    }


}
