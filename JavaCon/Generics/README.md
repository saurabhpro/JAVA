# The most commonly used Type Parameter names are:

```
E - Element (used extensively by the Java Collections Framework)

K - Key

N - Number

T - Type

V - Value

S, U, V etc. - 2nd, 3rd, 4th types
```

_Some examples:_

* **`Map<K, V>`**: A map usually assigns Values to Keys. These are special kinds of types, so they are used here.

* **`List<E>`**: A list contains Elements. It's a convention that they are called elements. On the other hand, T would also be acceptable here.

* **`Formatter<T>`**: A formatter can format any Type. It's not really an element, nor a key, nor a value, so T is the correct letter here.

* **`Triplet<T, U, V>`**: A triplet for arbitrary types. Since the type definition does not know anything about the types that will be filled in later, it uses just the T for the first type, followed by the next letters in alphabetical order.


## Erasure
- `List<String>` -> List
- `List<String>[]` -> List[]
- `T without Bounds` -> Object
- `T extends Foo` -> Foo


# What is reifiable and non-reifiable java ?

- a reifiable type is one whose runtime representation contains same information than its compile-time representation

- a non-reifiable type is one whose runtime representation contains less information than its compile-time representation

Arrays are reifiable as arrays remains as it is at runtime 

While generics information attached with List is erased at runtime by erasures

So `List<String> list=new ArrayList<String>`

at runtime will be 

`List list=new ArrayList();`

all generics information is erased. This is done to support the legacy code that is written without using generics.


But in case of arrays 

`Object[] ojb=new Object[0]`

will remain the same at runtime as well. 

Hence Generics are not mixed with arrays.

Some types are available at compile time and some types are at run time. Types that are completely available at run time are called Reifiable types.

### More 

Reification refers to the act of converting into or regarding as a concrete thing. 
A reifiable type exposes its complete type information at runtime. 

Examples include primitive types, non-generic types, and raw types. 


In contrast, a non-reifiable type has type information removed at compile time by type erasure, 
which ensures binary compatibility with Java libraries and applications that were created before generics. 
Examples include `List<String> and List<Integer>`. 

Because a non-reifiable type isn't completely available at runtime, the Java virtual machine (JVM) can't tell 
the difference between `List<String> and List<Integer>`; at runtime, only the raw type List is available.

### A type is reifiable if and only if one of the following holds:
- It refers to a non-generic class or interface type declaration.
- It is a parameterized type in which all type arguments are unbounded wildcards
- It is a raw type
- It is a primitive type
- It is an array type whose element type is reifiable.
- It is a nested type where, for each type T separated by a ".", T itself is reifiable.

# SafeVargs
@SafeVarargs

Applying @SafeVarargs to a `static/final/private` method header or constructor header suppresses unchecked warnings about a non-reifiable varargs type at call sites (locations where the method/constructor is called), and also suppresses unchecked warnings about parameterized array creation at call sites.

A variable arity parameter(Varargs) with a non-reifiable element type can cause heap pollution and give rise to compile-time unchecked warnings. Such warnings are uninformative if the body of the variable arity method is well behaved with respect to the variable arity parameter.

1. It is a compile-time error if a fixed arity method or constructor declaration is annotated with the annotation @SafeVarargs.
2. @SafeVarargs is only applicable to static methods, final instance methods, and constructors, [**from Jdk 9 - even private methods**] the annotation is not usable where method overriding occurs.


### I've recently come across the java @SafeVarargs annotation. Googling for what makes a variadic function in Java unsafe left me rather confused (heap poisoning? erased types?), so I'd like to know a few things:

1. What makes a variadic Java function unsafe in the @SafeVarargs sense (preferably explained in the form of an in-depth example)?
2. Why is this annotation left to the discretion of the programmer? Isn't this something the compiler should be able to check?
3. Is there some standard one must adhere to in order to ensure his function is indeed varags safe? If not, what are the best practices to ensure it?

Ans - 1 ) There are many examples on the Internet and on StackOverflow about the particular issue with generics and varargs. Basically, it's when you have a variable number of arguments of a type-parameter type:

`void foo(T... args);`

In Java, varargs are a syntactic sugar that undergoes a simple "re-writing" at compile-time: `a varargs parameter of type X... is converted into a parameter of type X[]; and every time a call is made to this varargs method, the compiler collects all of the "variable arguments" that goes in the varargs parameter, and creates an array just like new X[] { ...(arguments go here)... }.`

This works well when the varargs type is concrete like String.... When it's a type variable like T..., it also works when T is known to be a concrete type for that call. 

e.g. if the method above were part of a class Foo<T>, and you have a Foo<String> reference, then calling foo on it would be okay because we know T is String at that point in the code.

However, it does not work when the "value" of T is another type parameter. In Java, it is impossible to create an array of a type-parameter component type (new T[] { ... }). 

So Java instead uses new Object[] { ... } (here Object is the upper bound of T; if there upper bound were something different, it would be that instead of Object), and then gives you a compiler warning.

So what is wrong with creating new Object[] instead of new T[] or whatever? Well, arrays in Java know their component type at runtime. Thus, the passed array object will have the wrong component type at runtime.

For probably the most common use of varargs, simply to iterate over the elements, this is no problem (you don't care about the runtime type of the array), so this is safe:
```java
@SafeVarargs
final void foo(T... args) {
    for (T x : args) {
        // do stuff with x
    }
}
```
However, for anything that depends on the runtime component type of the passed array, it will not be safe. Here is a simple example of something that is unsafe and crashes:
```java
class UnSafeVarargs
{
  static <T> T[] asArray(T... args) {
    return args;
  }

  static <T> T[] arrayOfTwo(T a, T b) {
    return asArray(a, b);
  }

  public static void main(String[] args) {
    String[] bar = arrayOfTwo("hi", "mom");
  }
}
```
The problem here is that we depend on the type of args to be T[] in order to return it as T[]. But actually the type of the argument at runtime is not an instance of T[].

**Ans  2, 3   )** If your method has an argument of type T... (where T is any type parameter), then:

- **Safe**: If your method only depends on the fact that the elements of the array are instances of T

- **Unsafe**: If it depends on the fact that the array is an instance of T[]

Things that depend on the runtime type of the array include: returning it as type T[], passing it as an argument to a parameter of type T[], getting the array type using .getClass(), passing it to methods that depend on the runtime type of the array, like List.toArray() and Arrays.copyOf(), etc.

# what does <?> mean

# explain < ? extends ABC>
