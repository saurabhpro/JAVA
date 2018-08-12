package Ch15_Threads_and_Locks.Q15_06_Synchronized_Methods;

class MyThread extends Thread {
    private final String name;
    private final String firstMethod;
    private final Foo foo;

    public MyThread(Foo f, String nm, String fM) {
        foo = f;
        name = nm;
        firstMethod = fM;
    }

    public void run() {
        if (firstMethod.equals("A")) {
            foo.methodA(name);
        } else {
            foo.methodB(name);
        }
    }
}
