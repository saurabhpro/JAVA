/**
 * Created by Saurabh on 9/2/2015.
 */

class A1 extends Exception {

}


public class OverloadingException {

    Number show() throws A1 {
        return null;    //ref abstraction in interfaces
    }
    // Integer show(){        return null;    } Not allowed as covarints

    void show(int i) {
    }

    //overloaded so good enough to throw whatever it likes
    void show(double d) throws Exception {
    }
}
