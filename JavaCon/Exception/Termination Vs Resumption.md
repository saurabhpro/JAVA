There are two basic models in exception-handling theory.

* Java(As do most languages, including _exceptions.try_with_resources.C++, exceptions.try_with_resources.C#, Python, D, etc.)_ supports termination,
 in which you assume that the error is so critical that there's no way to get back to
 where the exception occurred. Whoever threw the exception decided that there was no
 way to salvage the situation, and **they don't want to come back**.

* The alternative is called resumption.
It means that the exception handler is expected to do something to rectify the situation,
and then the faulting method is retried, presuming success the second time. If you want
resumption, **it means you still hope to continue execution after the exception is handled**.

If you want resumption-like behavior in Java,
don't throw an exception when you encounter an error.
Instead, call a method that fixes the problem.

Alternatively, place your try block inside
a while loop that keeps reentering the try block until the result is satisfactory.

* In Thread we have 