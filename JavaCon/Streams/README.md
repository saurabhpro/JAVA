**Spliterator** can be used to split given element set into multiple sets so that we can perform some kind of operations/calculations on each set in different threads independently, possibly taking advantage of parallelism. It is designed as parallel analogue of Iterator. Other than collections, the source of elements covered by a Spliterator could be, for example, an array, an IO channel, or a generator function.


https://blog.logentries.com/2015/10/java-8-introduction-to-parallelism-and-spliterator/

**Parallelism**
it is a term that refers to programming in a way to exploit multi-core CPU units. That is to say, to take a piece of work (a task) and break it out into separate units (sub-tasks) that can be processed in parallel. Then aggregating the results of all the processed units to complete the original work

For this to be successful, the processing on a unit should not have a dependency on any other unit – this processing should be stateless and also should not depend on the result of the processing of any other unit. 

This also raises the question of when to go for parallelism – there is an overhead in the added complexity of identifying and breaking out the units of work and then coordinating the parallel processing. Then there is also the issue of latency in reading the data – the savings found in using parallel cores for processing is to try to keep each CPU core busy all the time – which requires reading data as and when is needed without delay. Before embarking on a parallel processing architecture, some cost-benefit analysis is required to be sure that this is the right approach.