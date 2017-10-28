there is the concept of a container, defined in the Map interface, holding a group of key-value object pairs, which allow the use of a key to find a value – in this way an object (value) can be found using another object (key) that has been mapped to it.
A problem with using the containers of the Collections Framework in some form of parallel programming is that these containers are not thread-safe. Wrappers are provided for adding automatic synchronization (thread safety) but the drawback is that this introduces thread contention, where two or more threads are trying to access the same resource simultaneously and therefore cause the runtime to either suspend their execution or execute them more slowly.


## Map.Entry <K, V>
1.	HashMap class has one nested interface with name `Entry` (`Node` from JDK 1.8) which implements one interface called `Map.Entry` interface 

2.	Map interface is also having one method interface called Entry and this interface has got 3 method 
3.	Whenever we create the object of HashMap class using default Constructor and then one Entry (Node from JDK 1.8) class on array will be created of size 16 which is known as capacity of HashMap 
4.	Each index of this array is called a `bucket` and each bucket is a `LinkedList`. 
6.	Whenever we add any key value pair in a HashMap class using a put () method then the put () method first convert this key value pair into the single object of Entry (Node from JDK 1.8) class 
and this Entry (Node from JDK 1.8) class object is going to be stored into the array of this class which is defined in a HashMap class


## How an Entry class object is stored in an array: ?
1. The `hashcode` of the key class object is first calculated

2. calculating the remainder of this hashcode % total number of bucket or capacity 
3. this reminder is treated as index of bucket
4. once the bucket is decided then the `equals()` is called on a key class object and then passes existing key class object into this method one by one. 
    - If the match is found from the entry class object, it does not add into the bucket but the value of the key in the bucket will be replaced by the new value 
    
    -  otherwise this entry class object is added in a bucket as first node of the linked list which is maintained by a bucket


## Some important points on HashMap
1. The default size of array is 16 (always a power of 2) and the load factors means whenever the size of HashMap reaches to 75% of the current size i.e. 12, it will double its size by re-computing the hash codes of existing Data Structure elements 

2. To avoid re-hashing of data structure (as it degrades the performance) as element grow it is best practice to explicitly give the size of HashMap while creating it 
    - It never gives the capacity to high and the load factor too low 
3.	Since Java is multithreaded it is very possible that more than one thread might be using same HashMap and then they both realize the need for resizing the HashMap at the same time, which lead to race condition 

4. The HashMap class uses a Hash table to implement the map interface. The HashMap class in not thread safe and permits only one null key and null value.
5. The HashMap class is roughly equal to the Hashtable except that it is unsynchronized and permits null. This class makes no guarantee as to the order of the map.
6. HashMap can be synchronized by using a method map m = collection synchronized map
   

## What is race condition with respect to HashMap?
- when someone sees the need for resizing the same HashMap, they might end up adding the elements of 
old buckets to the new buckets simultaneously and hence might lead to infinite loops. 

- in case of Collision i.e. when there are different keys with same hashcode, internally we use singly linked 
list to store the elements and we store every new element at the head of a linked list to avoid tail traversing 
and hence at the time of resizing the entire sequence of object in the linked list gets reversed, during which 
there are chances of infinite loop.

    example => let's assume there are three keys with the same hashcode and hence are stored in linked list inside a bucket which becomes infinite loop for the next iteration and thread hangs here.
