**Shallow vs. Deep Copies**

Some of the collection classes provide a clone() method that the documentation says creates a shallow copy of the collection. 
This means the object that’s created results in only a copy of the collection itself and not the objects it contains. 
Instead, a collection is created with references to the same objects that are contained within the collection that was cloned. 
This is an important concept to understand, particularly if the objects in the collection have state that can be changed. 
In that situation, a programmer might create a clone of a collection and modify objects in the newly created collection without realizing that they were also modifying the objects in the original collection. 

If you need to create a deep copy of a collection where the collection and its elements are both copied, then you must implement the code yourself that will make copies of the elements and store them in the new collection.