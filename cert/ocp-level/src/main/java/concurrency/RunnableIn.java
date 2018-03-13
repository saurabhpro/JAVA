package concurrency;


public class RunnableIn {
	public static void main(String[] args) {
		Runnable th = () -> {
			System.out.print("this");
		};

		th.run();
		/*
		 * While the following code snippets will compile, none will actually execute a task on a separate processing thread.
		 * Instead, the thread that made the call will be used to execute the task,
		 * causing the thread to wait until each run() method is complete before moving on to the next line.
		 */

		Thread t = new Thread(th);
		t.start();
	}

}
