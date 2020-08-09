/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package from.pluralsight.runnable.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings("Convert2MethodRef")
public class RunningA {

    public static void main(String[] args) throws InterruptedException {

        A a = new A();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable r1 = () -> a.a();
        Runnable r2 = () -> a.b();

//        final Future<?> submit1 = executorService.submit(r1, "Yay1");
//        final Future<?> submit = executorService.submit(r2);
//		[pool-1-thread-2] I am in b()
//		[pool-1-thread-1] I am in a()




        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        //[Thread-1] I am in b()
		//[Thread-0] I am in a()

        t1.join();
        t2.join();
    }
}
