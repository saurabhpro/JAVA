/**
 * Created by Saurabh on 8/31/2015.
 */

class WithinInner {
    class Inner {
        Inner() {
            System.out.println("Inside Inner constructor via super of InheritInner!");
        }
    }
}

/**
 * only writing WithinInner.Inner says : No enclosing instance of type WithinInner in this class :)
 */
public class InheritInner extends WithinInner.Inner {
    //so this  default constructor wont work, Not an error but program wont compile
    //InheritInner(){ }         //has to be commented out
    // Error:(14, 21) java: an enclosing instance that contains WithinInner.Inner is required

    InheritInner(WithinInner wi) {

        //enclosingClassReference.super();
        wi.super();
    }


    public static void main(String[] args) {
        WithinInner wi = new WithinInner();

        //sending the instance of type WithinInner via InheritInner Constructor
        InheritInner ii = new InheritInner(wi);
    }
}
