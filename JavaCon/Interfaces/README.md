# Java 8


1) Default methods can be overridden in implementing class, while static cannot.

2) Static method belongs only to Interface class, so you can only invoke static method on Interface class, not on class implementing this Interface, see:
```java
public interface MyInterface {
    default void defaultMethod(){
        System.out.println("Default");
    }

    static void staticMethod(){
        System.out.println("Static");
    }    
}

public class MyClass implements MyInterface {

    public static void main(String[] args) {

        MyClass.staticMethod(); //not valid - static method may be invoked on containing interface class only
        MyInterface.staticMethod(); //valid
    }
}
```
3) Both class and interface can have static methods with same names, and neither overrides other!
```java
public class MyClass implements MyInterface {

    public static void main(String[] args) {

        //both are valid and have different behaviour
        MyClass.staticMethod();
        MyInterface.staticMethod();
    }

    static void staticMethod(){
        System.out.println("another static..");
    }
}
```


## Why were default and static methods added to interfaces in Java 8 when we already had abstract classes?


In Java 8, interfaces can contain implemented methods, static methods, and the so-called "default" methods (which the implementing classes do not need to override).

In Interface (probably naive) view, there was no need to violate interfaces like this. Interfaces have always been a contract you must fulfill, and this is a very simple and pure concept. Now it is a mix of several things. In Interface opinion:

	1.	static methods do not belong to interfaces. They belong to utility classes.
	2.	"default" methods shouldn't have been allowed in interfaces at all. You could always use an abstract class for this purpose.

In short:
Before Java 8:

	•	You could use abstract and regular classes to provide static and default methods. The role of interfaces is clear.
	•	All the methods in an interface should be overriden by implementing classes.
	•	You can't add a new method in an interface without modifying all the implementations, but this is actually a good thing.

After Java 8:

	•	There's virtually no difference between an interface and an abstract class (other than multiple inheritance). In fact you can emulate a regular class with an interface.
	•	When programming the implementations, programmers may forget to override the default methods.
	•	There is a compilation error if a class tries to implement two or more interfaces having a default method with the same signature.
	•	By adding a default method to an interface, every implementing class automatically inherits this behavior. Some of these classes might have not been designed with that new functionality in mind, and this can cause problems. For instance, if someone adds a new default method default void foo() to an interface Ix, then the class Cx implementing Ix and having a private foo method with the same signature does not compile.

What are the main reasons for such major changes, and what new benefits (if any) do they add?

# Java 9
## Private methods
## Private static methods
[Example](/src/main/java/saurabh/Interface/Java9/ReportGeneratorJava9.java)


## In Java SE 9 and later versions, an interface can have only two kinds of things:

 - Constant variables
 - Abstract methods
 - Default methods
 - Static methods
 - Private methods
 - Private Static methods

 ### Benefits with “Java SE 9: private methods in Interface” New Feature:

- No need to write Duplicate Code i.e. Code Re-usability.
- We can expose only our intended methods to clients.


## Why can I not have a interface inside of a inner class? Why are they inherently static?
Think about what static means - `"not related to a particular instance"`. So, as you point out, a static field of class Foo is a field that does not belong to any Foo instance, but rather belongs to the Foo class itself.

Now think about what an interface is - `it's a contract, a list of methods that classes which implement it promise to provide`. So- interface is a set of methods that is "not related to a particular class" - any class can implement it, as long as it provides those methods.

So, if an interface is not related to any particular class, clearly one could not be related to an instance of a class - right?

*Note: there are ways of defining interfaces within classes. But, for the purposes of wrapping your head around what an interface is (which seems to be what you're working on), I would ignore those possibilities for now as they distract from and possibly obscure the purpose of interfaces in general.