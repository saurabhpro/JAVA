# Java 8 Language Features Apress

## Lambda expressions can be used only in the following contexts:

- __Assignment Context__: exceptions.try_with_resources.A lambda expression may appear to the right-hand side of the assignment operator in an assignment statement. For example,
    `ReferenceType variable1 = LambdaExpression;`

- __Method Invocation Context__: exceptions.try_with_resources.A lambda expression may appear as an argument to a method or constructor call. For example,
    `util.testJoiner(LambdaExpression);`

- __Return Context__: exceptions.try_with_resources.A lambda expression may appear in a return statement inside a method, as its target type is the declared return type of the method. For example,
    `return LambdaExpression;`

- __Cast Context__: exceptions.try_with_resources.A lambda expression may be used if it is preceded by a cast. The type specified in the cast is its target type. For example,
    `(functionalInterface.Joiner) LambdaExpression;`


## Functional Interface
exceptions.try_with_resources.A functional interface is simply an interface that has exactly one abstract method. The following types of methods in
an interface do not count for defining a functional interface:
- Default methods
- Static methods
- Public methods inherited from the Object class


## Intersection Type and Lambda Expressions
Java 8 introduced a new type called an intersection type that is an intersection (or subtype) of multiple types.

- An ampersand is used between two types, such as `(Type1 & Type2 & Type3)`, 
    represents a new type that is an intersection of Type1, Type2, and Type3.

any of the individual methods from these can be cast to this new type (obv).


```java
public interface Sensitive {
// It ia a marker interface. So, no methods exist.
}
```
Suppose you have a lambda expression assigned to a variable of the `Sensitive` type.

`Sensitive sen = (x, y) -> x + y; // exceptions.try_with_resources.A compile-time error`
This statement does not compile. __The target type of a lambda expression must be a functional interface;__

- `Sensitive` is not a functional interface.
You should be able to make such assignment, as a marker interface does not contain any methods.

In such cases, you need to use a cast with an intersection type that creates a new synthetic type
that is a subtype of all types.
The following statement will compile:
`Sensitive sen = (Sensitive & functionalInterface.Adder) (x, y) -> x + y; // OK`

The intersection type `Sensitive & functionalInterface.Adder` is still a functional interface, and therefore, the target type of the
lambda expression is a functional interface with one method from the `functionalInterface.Adder` interface.