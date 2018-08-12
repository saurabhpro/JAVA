### 13.2 Return from Finally: In Java, does the finally block get executed if we insert a return statement inside the try block of a try-catch-finally?
Yes, it will get executed. The finally block gets executed when the try block exits. Even when we attempt to exit within the try block (via a return statement, a continue statement, a break statement or any exception), the finally block will still be executed.

Note that there are some cases in which the finally block `will not get executed`, such as the following:
- If the virtual machine exits during try/catch block execution.
- If the thread which is executing during the try/ catch block gets killed.

### 13.3 What is the difference between final, finally, and finalize? SOLUTIONS
Despite their similar sounding names, final, finally and finalize have very di erent purposes.   speak in very general terms, final is used to control whether a variable, method, or class is "change­ able:' The finally keyword is used in a try/ catch block to ensure that a segment of code is always executed. The finalize() method is called by the garbage collector once it determines that no more references exist.

Further detail on these keywords and methods is provided below.

__final__

The final statement has a different meaning depending on its context.
When applied to a variable (primitive):The value of the variable cannot change.
- When applied to a variable (reference): The reference variable cannot point to any other object on the heap.
- When applied to a method: The method cannot be overridden.
- When applied to a class:The class cannot be subclassed.

__Finally keyword__

There is an optional finally block after the try block or after the catch block. Statements in the finally block will always be executed, even if an exception is thrown (except if Java Virtual Machine exits from the try block). The finally block is o en used to write the clean-up code. It will be executed after the try and catch blocks, but before control transfers back to its origin.

__finalize()__

The automatic garbage collector calls the finalize () method just be re actually destroying the object. A class can therefore override the finalize () method from the Object class in order to define custom behavior during garbage collection.
```java
protected void finalize() throws Throwable {};
/* Close open files, release resources, etc */
```

### Generics vs.Templates: Explain the difference between templates in C++ and generics in Java. 
Many programmers consider templates and generics to be essentially equivalent because both allow you to do something like List<String>. But, how each language does this, and why, varies significantly.

The implementation of Java generics is rooted in an idea of `"type erasure`:'This technique eliminates the parameterized types when source code is translated to the Java Virtual Machine (JVM) byte code.

Java generics and C++ templates have a number of other differences. These include:
- C++ templates can use primitive types, like int. Java cannot and must instead use Integer.
- InJava,you can restrict the template's type parameters to be of a certain type.For instance,you might use generics to implement a CardDeck and specify that the type parameter must extend from CardGame.
- In C++, the type parameter can be instantiated, whereas Java does not support this.
- In Java, the type parameter (i.e., the Foo in MyClass<Foo>) cannot be used for static methods and variables, since these would be shared between MyClass<Foo> and MyClass<Bar>. In C++, these classes are di erent, so the type parameter can be used for static methods and variables.
- In Java, all instances of MyClass, regardless of their type parameters, are the same type. The type parameters are erased at runtime. In C++, instances with different type parameters are di erent types.

Remember: Although Java generics and C++ templates look the same in many ways, they are very different.

### 13.5 Explain the differences between TreeMap, HashMap, and LinkedHashMap. Provide an example of when each one would be best.
All offer a key->value map and a way to iterate through the keys. The most important distinction between these classes is the time guarantees and the ordering of the keys.
- HashMap offers `0(1)` lookup and insertion. If you iterate through the keys, though, the ordering of the keys is essentially arbitrary. It is implemented by an array of linked lists.
- TreeMap offers `O(log N)` lookup and insertion. Keys are ordered, so if you need to iterate through the keys in sorted order, you can. This means that keys must implement the Comparable interface. __TreeMap is implemented by a Red-Black Tree.__
- LinkedHashMap offers `0(1)` lookup and insertion. Keys are ordered by their insertion order. It is implemented by doubly-linked buckets.

__Very important__: The output of LinkedHashMap and TreeMap must look like the above. For HashMap, the output was, in my own tests, { 0, 1, -1}, but it could be any ordering. There is no guarantee on the ordering.

__When might you need ordering in real life?__

Suppose you were creating a mapping of names to Person objects. You might want to periodically output the people in alphabetical order by name. A TreeMap lets you do this.
- A TreeMap also offers a way to, given a name, output the next 10 people. This could be useful for a "More" function in many applications.
- A LinkedHashMap is useful whenever you need the ordering of keys to match the ordering of insertion. This might be useful in a caching situation, when you want to delete the oldest item.

Generally, unless there is a reason not to, you would use HashMap. That is, if you need to get the keys back in insertion order, then use LinkedHashMap. If you need to get the keys back in their true/natural order, then use TreeMap. Otherwise, HashMap is probably best. It is typically faster and requires less overhead.
