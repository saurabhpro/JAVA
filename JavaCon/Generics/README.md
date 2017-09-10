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

{quote}

### A type is reifiable if and only if one of the following holds:
- It refers to a non-generic class or interface type declaration.
- It is a parameterized type in which all type arguments are unbounded wildcards
- It is a raw type
- It is a primitive type
- It is an array type whose element type is reifiable.
- It is a nested type where, for each type T separated by a ".", T itself is reifiable.

## SafeVargs
@SafeVarargs

Applying @SafeVarargs to a `static/final/private` method header or constructor header suppresses unchecked warnings about a non-reifiable varargs type at call sites (locations where the method/constructor is called), and also suppresses unchecked warnings about parameterized array creation at call sites.

A variable arity parameter(Varargs) with a non-reifiable element type can cause heap pollution and give rise to compile-time unchecked warnings. Such warnings are uninformative if the body of the variable arity method is well behaved with respect to the variable arity parameter.

1. It is a compile-time error if a fixed arity method or constructor declaration is annotated with the annotation @SafeVarargs.
2. @SafeVarargs is only applicable to static methods, final instance methods, and constructors, [**from Jdk 9 - even private methods**] the annotation is not usable where method overriding occurs.

 ### @SafeVarargs introduced in JDK 7,
 
 * the main purpose is to deal with variable long parameters in the generic,
 * this annotation tells the compiler: variable in the variable parameters of the type is safe.
 
 * Variable-length parameters are stored using arrays, and arrays and generics can not be mixed well
 
 * Simply put, the data type of the array element is determined at compile time and runtime,
 * and the generic data type can only be determined at runtime, so when a generic is stored in an array,
 * the compiler is in the compile phase Can not check whether the data type matches, so a warning message is given: `there is a possible "heap pollution", that is, if the generic data type of the generic can not match the type of the argument array, it will cause a ClassCastException.`

* So the compiler gives a warning when using generics in variable-length arguments.
## what does <?> mean

## explain < ? extends ABC>
