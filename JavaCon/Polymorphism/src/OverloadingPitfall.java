/**
 * Created by Saurabh on 7/30/2015.
 */
public class OverloadingPitfall {
    int x, y;

    void overload(int a, long b) {
        System.out.println("Inside Int long");
    }

    void overload(long a, int b) {
        System.out.println("Inside Long Int");
    }

    void overload(int a) {
        System.out.println("Inside Int");
    }

    void overload(long a) {
        System.out.println("inside Long");
    }

    void overload(float a) {
        System.out.println("Inside Float");
    }

    void overload(double a) {
        System.out.println("Inside double");
    }

    public static void main(String[] args) {
        OverloadingPitfall ob = new OverloadingPitfall();
        //ob.overload(4, 5); //Error:(38, 11) java: reference to overload is ambiguous [both method match]
        ob.overload(6.7);
        ob.overload(6.7f);
        ob.overload(8);
        ob.overload(8L);
    }
}

/*Output
Inside double
Inside Float
Inside Int
inside Long
 */