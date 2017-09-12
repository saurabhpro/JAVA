# L is for Liskov Substitution Principle

The Liskov Substitution Principle (LSP) is the one here that is most unique to object-oriented programming. The LSP says, basically, that any child type of a parent type should be able to stand in for that parent without things blowing up.

In other words, if you have a class, Animal, with a MakeNoise() method, then any subclass of Animal should reasonably implement MakeNoise(). Cats should meow, dogs should bark, etc. 

- What you wouldn't do is define a MuteMouse class that throws IDontActuallyMakeNoiseException. This violates the LSP, and the argument would be that this class has no business inheriting from Animal.

To picture this, imagine cooking yourself a stew. If you're anything like me, you'd only put things in there that were edible because you would want to eat the stew without picking through each bite, asking yourself repeatedly, "is this edible?"


## The following are some of the code quality characteristics that are represented by the Liskov Substitution Principle.


- It is only when derived types are completely substitutable for their base types that functions that use those base types can be reused with impunity, and the derived types can be changed with impunity.

- The LSP is also, at times, termed as “Design by Contract.” Using this scheme, methods of classes declare pre-conditions and post-conditions. The pre-conditions must be true in order for the method to execute. Upon completion, the method guarantees that the post-condition will be true.

- Design by Contract does influence the declaration of “throws” exceptions, as well as the throwing of runtime exceptions and try/catch in general.