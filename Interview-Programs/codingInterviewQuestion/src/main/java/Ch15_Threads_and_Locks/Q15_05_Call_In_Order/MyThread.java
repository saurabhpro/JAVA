package Ch15_Threads_and_Locks.Q15_05_Call_In_Order;

class MyThread extends Thread {
    private final String method;
    private final FooBad foo;

    public MyThread(FooBad foo, String method) {
        this.method = method;
        this.foo = foo;
    }

    public void run() {
        if (method == "first") {
            foo.first();
        } else if (method == "second") {
            foo.second();
        } else if (method == "third") {
            foo.third();
        }
    }
}
