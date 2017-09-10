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

Arrays are reifiable as arrays remains as it is at runtime While generics information attached with List is erased at runtime by erasures

So `List<String> list=new ArrayList<String>`

at runtime will be 

`List list=new ArrayList();`

all generics information is erased. This is done to support the legacy code that is written without using generics.


But in case of arrays 

`Object[] ojb=new Object[0]`

will remain the same at runtime as well. Generics are not mixed with arrays.

