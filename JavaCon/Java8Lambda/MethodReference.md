##Java 8 Method Reference

A method reference is the shorthand syntax for a lambda expression that executes just ONE method. 
Here's the general syntax of a method reference:

`Object :: methodName`

We know that we can use lambda expressions instead of using an anonymous class. 
But sometimes, the lambda expression is really just a call to some method, for example:

`Consumer<String> c = s -> System.out.println(s);`

To make the code clearer, you can turn that lambda expression into a method reference:

`Consumer<String> c = System.out::println;`



_In a method reference, you place the object (or class) that contains the method before the :: operator 
and the name of the method after it without arguments._

**They can only be used to replace a single-method lambda expression.**

So to use a method reference, you first need a lambda expression with __one method__. 
And to use a lambda expression, you first need a **functional interface**, _an interface with just one abstract method_.

There are four types of method references:

1. **A method reference to a static method.**
    - `(args) -> Class.staticMethod(args)` can be converted to
    - `Class::staticMethod`
    - Where ever we can pass a lambda expression that just calls a static method, we can use a method reference. 
    - 
2. **A method reference to an instance method of an object of a particular type.**
    - `(obj, args) -> obj.instanceMethod(args)` can be converted to
    - `ObjectType::instanceMethod`
    
    - an instance of the object is the parameter of the lambda expression, and we form the reference to the instance method with the type of the instance.
     
    - Java has a Function interface that takes one parameter, a BiFunction that takes two parameters, but there's no TriFunction that takes three parameters, so let's make one: [Click Here](src/main/java/pluralsight/util/methodReference/instanceEx)
      

3. **A method reference to an instance method of an existing object.**
    - `(args) -> obj.instanceMethod(args)` to
    - `obj::instanceMethod`
    
4. **A method reference to a constructor.**
    - `(args) -> new ClassName(args)` to
    - `ClassName:: new`
    - If the constructor takes no arguments, a Supplier will do the job: [Click Here](src/main/java/pluralsight/util/methodReference/constructorEx/WithoutArgument.java)
    - If the constructor takes an argument, we can use the Function interface. If the constructor takes two arguments, we use the BiFunction interface: [Click Here](src/main/java/pluralsight/util/methodReference/constructorEx/WithArgument.java)


