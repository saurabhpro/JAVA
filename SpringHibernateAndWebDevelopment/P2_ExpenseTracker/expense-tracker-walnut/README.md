	
__@ElementCollection__ is a standard JPA annotation, which is now preferred over the proprietary 
	Hibernate annotation CollectionOfElements.

It means that the collection is not a collection of entities, but a collection of simple types (Strings, etc.) 
	or a collection of embeddable elements (class annotated with @Embeddable).

It also means that the elements are completely owned by the containing entities: 
	they're modified when the entity is modified, deleted when the entity is deleted, etc. 
	They can't have their own lifecycle.
	

### [3.4.5. Limiting query results](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.limit-query-result)
The results of query methods can be limited via the keywords first or top, which can be used interchangeably. An optional numeric value can be appended to top/first to specify the maximum result size to be returned. If the number is left out, a result size of 1 is assumed.

Example 15. Limiting the result size of a query with Top and First
```java
User findFirstByOrderByLastnameAsc();

User findTopByOrderByAgeDesc();

Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);

Slice<User> findTop3ByLastname(String lastname, Pageable pageable);

List<User> findFirst10ByLastname(String lastname, Sort sort);

List<User> findTop10ByLastname(String lastname, Pageable pageable);
```
The limiting expressions also support the Distinct keyword. Also, for the queries limiting the result set to one instance, wrapping the result into an Optional is supported.

If pagination or slicing is applied to a limiting query pagination (and the calculation of the number of pages available) then it is applied within the limited result.

Note that limiting the results in combination with dynamic sorting via a Sort parameter allows to express query methods for the 'K' smallest as well as for the 'K' biggest elements.

### 3.4.6. Streaming query results
The results of query methods can be processed incrementally by using a Java 8 Stream<T> as return type. Instead of simply wrapping the query results in a Stream data store specific methods are used to perform the streaming.

Example 16. Stream the result of a query with Java 8 Stream<T>
```java
@Query("select u from User u")
Stream<User> findAllByCustomQueryAndStream();

Stream<User> readAllByFirstnameNotNull();

@Query("select u from User u")
Stream<User> streamAllPaged(Pageable pageable);
```
A Stream potentially wraps underlying data store specific resources and must therefore be closed after usage. You can either manually close the Stream using the close() method or by using a Java 7 try-with-resources block.
Example 17. Working with a Stream<T> result in a try-with-resources block
```java
try (Stream<User> stream = repository.findAllByCustomQueryAndStream()) {
  stream.forEach(…);
}
```
Not all Spring Data modules currently support Stream<T> as a return type.