import java.util.ConcurrentModificationException;

/**
 * Created by Saurabh on 9/2/2015.
 */

class Animal extends ArithmeticException {
    public void eat() throws Exception {
    }

    public void sleep() throws Animal {
    }
}

class Dog extends Animal {
    /**
     * Overriding functions mustn't throw checked exceptions that are new or broader
     * than those declared by the overridden method of base class
     * <p>
     * Overriding functions can however throw narrower or fewer exceptions or even no exception.
     * "just because base class method takes risk, doesn't mean overriding method takes the same risk
     */
    @Override   //valid for an subclass overriding method to not throw an error
    public void eat() {
        System.out.println("Inside Child No Exception");
    }

    // public void eat() throws Throwable{ } // this is not valid as Throwable > Exception

    /**
     * throwing an Animal that is subclass of ArithmeticException in base class, now throwing NumberFormatException
     * that also inherits from same ArithmeticException, so equal breadth of both Exception
     */
    @Override
    public void sleep() throws NumberFormatException {
    }//or no exception also valid
}

class OverridingInException extends Animal {
    //valid as Exception > ConcurrentME
    @Override
    public void eat() throws ConcurrentModificationException {
    }

    @Override
    public void sleep() throws Dog {
    }

    /* Not a legal overload
    public String eat(){
        return null;
    }
    */

    //Overloaded function
    public void eat(int g) throws Throwable {
    }
    //This is perfectly valid!
    //as overloaded methods are new and not overriding anything
}
