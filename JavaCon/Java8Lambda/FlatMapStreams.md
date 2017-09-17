In Java 8, Stream can hold different data types, for examples:
```java
Stream<String[]>
Stream<Set<String>>
Stream<List<String>>
Stream<List<Object>>
```

But, the Stream operations (filter, sum, distinct…) and collectors do not support it, so, we need flatMap() to do the following conversion :

```java
Stream<String[]>	-> flatMap ->	Stream<String>
Stream<Set<String>>     -> flatMap ->	Stream<String>
Stream<List<String>>	-> flatMap ->	Stream<String>
Stream<List<Object>>	-> flatMap ->	Stream<Object>
```

How flatMap() works :
```
{ {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}

{ {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
```