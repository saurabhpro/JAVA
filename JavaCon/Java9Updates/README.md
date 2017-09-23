## Java 9 @Deprecated Enhancements
   
   This article introduces new added methods of Java 9 @Deprecated annotation: forRemoval() and since().
   
   An example with new @Deprecated annotation:
   @Deprecated(since ="1.5", forRemoval = true)
   
   
1. __forRemoval()__ :   forRemoval() returns a boolean:
    - true means that “this API element is earmarked for removal in a future release”. Who uses the API should notice that, if they don’t migrate away from the API, their code could be break when new release is issued.
    - false indicates that the API element is deprecated, but without any specific intent to remove that API in the future. It is just a recommendation to migrate away from this API.
    - The default value of this element is false.
   
2. __since()__:   since() returns a String.
    - “This string should contain the release or version number at which this API became deprecated.” Although it has free-form syntax, the string should follow the same scheme as the @since Javadoc tag for the project containing the deprecated API.
    - The default value of this element is the empty string.
   
EX.

```java
 /**
 * 
 * @deprecated
 * This class and the {@link Observer} interface have been deprecated.
 * The event model supported by {@code Observer} and {@code Observable}
 * is quite limited, the order of notifications delivered by
 * {@code Observable} is unspecified, and state changes are not in
 * one-for-one correspondence with notifications.
 * For a richer event model, consider using the
 * {@link java.beans} package.  For reliable and ordered
 * messaging among threads, consider using one of the concurrent data
 * structures in the {@link java.util.concurrent} package.
 * For reactive streams style programming, see the
 * {@link java.util.concurrent.Flow} API.
 */
 @Deprecated(since="9", forRemoval=true)
public class Observable {/**/}
```

## Java SE 7: Try-With-Resources Basics
   
Java SE 7 has introduced a new construct: Try-With-Resources Statement for better Exception Handling. Without this construct, Developer has to write lot of redundant and ugly code. If Developer forgets about closing resources properly, we will get Resource Leakage issues in our application.
 
**The main goals of this new feature is :**
- Avoid writing some extract catch/finally block.
- Better Readable Code
- No need to do null checks
- No need to check whether Resource reference is referring to an object or null.
- Better Resource Management
- ARM (Automatic Resource Management)
- To avoid memory leakages
   
### Java SE 7 or 8: Try-With-Resources Rules

- Any Resource (which Pre-defined Java API class or User Defined class) must implement `java.lang.AutoCloseable`.
- Resource object must refer either final or effectively final variable ( a variable that's declared and never modified is `effective final`)
- If Resource is already declared outside the Try-With-Resources Statement, we should re-refer with local variable (The Bug Ref: code). That newly created local variable is valid to use within Try-With-Resources Statement.

### Java SE 9: Try-With-Resources Improvements

As we discussed in previous sections, Java SE 7 or 8 versions have one small issue or bug with this statement.

- In Java SE 9, if we have a resource which is already declared outside the Try-With-Resource Statement as final or effectively final, then we do NOT need to declare a local variable. 
 
## ImmutableSingleton Collections
In Java SE 8 and earlier Versions, if we want to create an empty Immutable or Unmodifiable List, we should use Collections class utility method: unmodifiableList as shown below:

Example:-
```java
 List<String> emptyList = new ArrayList<>();
 List<String> immutableList = Collections.unmodifiableList(emptyList);
  
```
 
 ### Characteristics of Immutable List
 
 As we know, Immutable Lists are not modifiable (unmodifiable collections). In this section, we will discuss the Characteristics of Immutable List(They are same in all Java versions.):
 
 - They are Immutable.
 - We cannot add, modify and delete their elements.
 - If we try to perform Add/Delete/Update operations on them, we will get UnsupportedOperationException
 - They don’t allow null elements.
 - If we try to create them with null elements, we will get NullPointerException
 - If we try add null elements, we will get UnsupportedOperationException
 - They are serializable if all elements are serializable.

## the deprecation of the method Object.finalize().

The deprecation of a method present on Java's Object type, would be a highly unusual step. The finalize() method has been present since Java 1.0, and is widely regarded as a misfeature and a significant piece of legacy cruft in the platform.

An object that overrides finalize() is treated specially by the garbage collector. Usually, an object is immediately destroyed during the collection cycle after the object is no longer in scope. However, finalizable objects are instead moved to a queue, where separate finalization threads will drain the queue and run the finalize() method on each object. Once the finalize() method terminates, the object will at last be ready for garbage collection in the next cycle.

The aim of the mechanism was to provide an equivalent in Java to the exceptions.try_with_resources.C++ RAII pattern, where resources (such as filehandles) are acquired when an object is created and automatically released when the object is destroyed.

However, finalization does not safely implement automatic resource management, as the garbage collector does not run with any time guarantees. This means that there is nothing in the mechanism which ties resource release to the lifetime of the object, and so it is always possible to exhaust resources.

Using finalization is therefore not fit for the main purpose it was originally implemented.

The advice given to developers by Oracle (and Sun) has, for many years, been to avoid finalization in ordinary application code. This deprecation is a first step towards eventual removal, but all it actually does is to introduce a formal compiler warning if the finalization mechanism is used.