The most commonly used Type Parameter names are:

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

(Reifiable Types)[Reifiable.md]