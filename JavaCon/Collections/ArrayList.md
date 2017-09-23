1.	ArrayList is not `synchronized`

2.	ArrayList supports dynamic array which can grow as needed.
 
3.	Size of ArrayList can be dynamically increased or decreased.

4.	ArrayList are created with initial `size = 10`.

5.	ArrayList contains duplicate elements unlike Set. ArrayList maintain insertion order of the element.

6.	ArrayList is not synchronized collection, hence it is not suitable to be used between multiple Threads concurrently. 

7. If you want to use ArrayList data structure in multithreaded environment, then you need to use the `CopyOnWriteArrayList` 
or use `Collection.Synchronized()` to create a synchronized list. 
Former is a part of concurrent collections package and is much more stable than the second one, but only useful when  there are many readers and writers. exceptions.try_with_resources.A new copy of ArrayList is created every time a write happens, it can be overkill if used in write heavy environment 
Second option is strictly synchronized collection, much like `Vector` and `Hashtable`, but is not scalable because once a number of threads increases drastically, contention become a huge issue.

8.	`CopyOnWriteArrayList` is recommended for concurrent multithreading environment as it is optimized for multiple concurrent reads and creates copy for write operation.
 this was added in JDK 1.5 Java.util.concurrent package along with `ConcurrentHashMap`.

9.	When ArrayList get full, it creates another array using `System.ArrayCopy` to copy all elements from one array to another array. This is where array insertion takes a lot of time.

10.	`Iterator` and `ListIterator` of Java ArrayList are `fail fast`. It means if ArrayList is structurally modified at any time after the Iterator is created in any way except the iterator’s own `add()`, `remove()` methods, the iterator will throw a `ConcurrentModificationException`
Thus, in the face of concurrent modification, the iterator fails quickly and clearly that's why it's called fail fast.

11.	Concurrent modification exception is not guaranteed and it is only thrown at best effort.

12.	If you are creating synchronized list, it is recommended to create it while creating an instance of underlying ArrayList to prevent accidental non-synchronized access to the list

13.	An application can increase the capacity of the ArrayList instance before adding a large number of elements using the ensureCapacity () operation. this may reduce the amount of incremental reallocation due to incremental filling of ArrayList

14.	The `size (), isEmpty (), get (), set (), iterator () and listIterator ()` operation run in constant time because the list is based on Array but adding and removing element is costly as compared to LinkList

15.	ArrayList class is enhanced in JDK 1.5 to support Generics which adds extra type safety on ArrayList.
It is recommended to use generics version of ArrayList to ensure that's your ArrayList contain only specific type of elements and avoid any __class cast exception__

16.	If we set ArrayList reference to null in Java, all the elements inside ArrayList becomes eligible for garbage collection in Java provided that there are no strong references exist for those objects

17.	Always use `isEmpty()` method to check if ArrayList is empty or not, instead of using `size () = 0`, check former one as it is more readable.


## How ArrayList works

Basic Data Structure used in an ArrayList is -

`private transient Object[] elementData; `

So it's an array of Object(Just the declaration.) 
When we actually create an arrayList following piece of code is executed -


`this.elementData = new Object[initialCapacity];`


You create an ArrayList as follows -
`List<String> myList = new ArrayList<String>();
List<String> myList = new ArrayList<String>(6);`

1st one invokes a default constructor while the second will invoke a constructor with an integer argument. 
When we create an ArrayList in the 2nd way it will internally create an array of Object with size specified in the constructor argument(6 in our case).

**Default value is 10**
i.e if no size is supplied array with size 10 is created.

Code for it is as follows -
```java
   /**
        * Constructs an empty list with the specified initial capacity.
        *
        * @param  initialCapacity  the initial capacity of the list
        * @throws IllegalArgumentException if the specified initial capacity
        *         is negative
        */
       public ArrayList(int initialCapacity) {
           if (initialCapacity > 0) {
               this.elementData = new Object[initialCapacity];
           } else if (initialCapacity == 0) {
               this.elementData = EMPTY_ELEMENTDATA;
           } else {
               throw new IllegalArgumentException("Illegal Capacity: "+
                                                  initialCapacity);
           }
       }
```

Once you tell this interviewer can be sure you know what data structure is internally used.
Now we know ArrayList is better than normal arrays as it is size dynamically increases. 
But how does this take place internally? How much does the size increase?

Inside `.add()` method there is this check. 
Before adding element into the array it will check what is the current size of filled elements and what is the maximum size of the array. 
If size of filled elements is greater than maximum size of the array(or will be after adding current element) 
then size of the array must be increased. But if you know array basic you cannot dynamically increase the array size. 
So what happens internally is a new Array is created with size `1.5 * currentSize` and 
the data from old Array is copied into this new Array.

Code for it is as follows -
```java

/**
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    
     /*
         * Private remove method that skips bounds checking and does not
         * return the value removed.
         */
        private void fastRemove(int index) {
            modCount++;
            int numMoved = size - index - 1;
            if (numMoved > 0)
                System.arraycopy(elementData, index+1, elementData, index,
                                 numMoved);
            elementData[--size] = null; // clear to let GC do its work
        }

```

trimToSize() to trim to say existing 5 elements when default size is set to 10


Objects.requireNonNull(action);

