**Tips for Reviewing a Fork/Join Class**

- The class should extend RecursiveAction or RecursiveTask<>.

- If the class extends RecursiveAction, then it should override a protected compute() method that takes no arguments and returns void.
- If the class extends RecursiveTask, then it should override a protected compute() method that takes no arguments and returns a generic type listed in the class definition.
- The invokeAll() method takes two instances of the fork/join class and does not return a result.
- The fork() method causes a new task to be submitted to the pool and is similar to the thread executor submit() method.
- The join() method is called after the fork() method and causes the current thread to wait for the results of a subtask.
- Unlike fork(), calling compute() within a compute() method causes the task to wait for the results of the subtask.
- The fork() method should be called before the current thread performs a compute() operation, with join() called to read the results afterward.
- Since compute() takes no arguments, the constructor of the class is often used to pass instructions to the task.