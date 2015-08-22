/**
 * Created by Saurabh on 8/30/2015.
 * <p>
 * Java – private constructor example
 * OOPS CONCEPT
 * The use of private constructor is to serve singleton classes. A singleton class is one which limits the
 * number of objects creation to one. Using private constructor we can ensure that no more than one object
 * can be created at a time. We will see in the below example how to use private constructor for limiting
 * the number of objects for a singleton class.
 */
/**
 * Java – private constructor example
 OOPS CONCEPT
 The use of private constructor is to serve singleton classes. A singleton class is one which limits the
 number of objects creation to one. Using private constructor we can ensure that no more than one object
 can be created at a time. We will see in the below example how to use private constructor for limiting
 the number of objects for a singleton class.
 */


/**
 *
 */
class Singleton {  //Static Class Reference
    private static Singleton obj = null;

    private Singleton() {
      /*Private Constructor will prevent
       * the instantiation of this class directly*/

        System.out.println("Inside private Constructor");
    }

    public static Singleton objectCreationMethod() {

    /*This logic will ensure that no more than one object can be created at a time */

        if (obj == null) {
            System.out.println("Creating Object of singleton");
            obj = new Singleton();
        } else
            System.out.println("Object of " +
                    "singleton already exists! ");
        return obj;
    }

    public static Singleton tryToCreate(Singleton ob) {
        obj = ob;
        System.out.println("Inside tryTocreate");
        return obj;
    }

    public void display() {
        System.out.println("Singleton class Example");
    }
}

/**
 * Notice : that even though constructor is provate , within one class that is also accessible so , always make new class
 */
public class PrivateConstructorSingleton {

    public static void main(String args[]) {
        //Object cannot be created directly due to private constructor
        //This way it is forced to create object via our method where
        //we have logic for only one object creation

        //Singleton myobject = new Singleton();       private constructor so not allowed

        Singleton myOb = Singleton.objectCreationMethod();
        myOb.display();

        //Singleton myOb2 = Singleton.tryToCreate(new Singleton());         still not allowed (null is allowed obv)
        Singleton myOb2 = Singleton.objectCreationMethod();
        myOb2.display();

        //to prove both myOb and myOb2 are same as if 2 objects created, ansr would be false
        System.out.println("myOb== myOb2 " + (myOb == myOb2));
    }
}