## [17.4. Memory Model](https://docs.oracle.com/javase/specs/jls/se7/html/jls-17.html#jls-17.4)

- A memory model describes, given a program and an execution trace of that program, whether the execution trace is a
  legal execution of the program. The Java programming language memory model works by examining each read in an
  execution trace and checking that the write observed by that read is valid according to certain rules.

    - The memory model describes possible behaviors of a program. An implementation is free to produce any code it
      likes, as long as all resulting executions of a program produce a result that can be predicted by the memory
      model.

### JMM basically means two things

- optimize/organize the instructions so that assembly code is optimized to have less read/writes
- maintain the visibility of fields at all time
    - like using volatile to keep local cache always write to shared cache

- We need to learn about "Happens-before" relationships as well -!! ?
- [Blog JMM 1](https://shipilev.net/blog/2014/safe-public-construction/) - Java Memory Model guarantees this if all the
  fields in object are final and there is no leakage of the under-initialized object from constructor.
- [Actual Amzaing descriptin ](https://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html)