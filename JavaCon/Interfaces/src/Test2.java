/**
 * Created by Saurabh on 8/5/2015.
 */
// filename: Test2.java
class Test1 {
    Test1(int x) {
        System.out.println("Constructor called " + x);
    }
}

// This class contains an instance of Test1
public class Test2 implements my {
    Test1 t1 = new Test1(10);

    Test2(int i) {
        t1 = new Test1(i);
    }

    public static void main(String[] args) {
        Test2 t2 = new Test2(5);

        my m = new Test2(5);    // my in interface and here a base class so this is allowed

        System.out.println('a' - 'A');
    }

    public void show()  //if public not given it sees an error : attmepting to give weaker access than public in interface
    {
        System.out.printf("Hey");
    }
}

interface my {
    void show();        //by default public and abstract
}

interface my2 extends my {
    void show();
}