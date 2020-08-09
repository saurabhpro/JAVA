/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package from.pluralsight.runnable.deadlock;

class A {

    private final Object key1 = new Object();
    private final Object key2 = new Object();

    void a() {
        synchronized (key1) {
            System.out.println("[" + Thread.currentThread().getName() + "] I am in a()");
            b();
        }
    }

    void b() {
        synchronized (key2) {
            System.out.println("[" + Thread.currentThread().getName() + "] I am in b()");
            c();

        }
    }

    private void c() {
        synchronized (key1) {
            System.out.println("[" + Thread.currentThread().getName() + "] I am in c()");
        }
    }
}
