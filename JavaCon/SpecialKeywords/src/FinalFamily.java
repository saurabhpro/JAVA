/**
 * Created by Saurabh on 8/16/2015.
 */

/**
 * Final data and reference
 */
class FinalData {
    static final int z; //STATIC BLANK FINAL VARIABLE
    //x = 8; not possible, not here nor anywhere including constructor or via some other function
    static final int w = 6;

    static {

        //System.out.println("Inside static block START : z = "+z); //z not initialized yet

        z = 9;  //this is the only way to initialize static blank final variables

        //System.out.println(x + y +" "+ z);        //x and y are non-static
        //System.out.println(w+" "+ z);                //illegal forward reference by w jbki w is static, Why ??

        System.out.println("Inside static block : z = " + z);

        //tmp = new Temp(); INVALID as temp is final
    }

    //a final variable initialized at creation is constant and un-changeable
    final int x = 7;
    //A static final variable that is not initialized at the time of declaration.
    // It can be initialized only in static block.


    final int y;    //BLANK FINAL VARIABLE  - is not initialized at the time of declaration
    // must be initialized in the constructor only (instance block too), WHY ?
    // or else it is an compile time error

    /*If you want to create a variable that is initialized at the time of creating object
    and once initialized may not be changed, it is useful.*/


    final Temp tmp = new Temp();        //reference final , that means content of object may change
    // but tmp with only point to this block of buffer/object only


    {
        //tmp = new Temp(); INVALID as temp is final
        //z = 7; valid but same as constructor

        //System.out.println(x + y + z);   //y not initialized yet as instance block runs just after super()

        y = 8;  // as this block  is part of constructor

        System.out.println(x + " " + z);
    }


    /*why only constructor - because it is the only method that runs atleast once at object creation
    constructor ensures blank final variable is given some value
     */
    FinalData() {
        //x = 8;    changing still not possible
        //y = 8;    valid... ask, why can't we write y = 9 anywhere else [//since we initialized in instance block]
        //z = 10;   valid but its not initializing class level z, has to happen before everything

        //tmp = new Temp(); INVALID as temp is final
    }
}

class Temp {
}

/**
 * Final argument in functions
 */
class FinalArguments {

    int x;

    FinalArguments(final int i) {
        System.out.println("Value of i at insertion = " + x);
        x = i;

        //i++;  cannot modify a final argument [same with reference]

    }
}

/**
 * Final methods with inheritance overriding
 */
class FinalMethods {
    final void change() {
        System.out.println("Change : " + getClass());
    }

    private void amIPrivate() {
        System.out.println("Private of base" + getClass());
    }
}

class Temp2 extends FinalMethods {

    // @Override
    // void change()   {  } cant do this as change is final


    // @Override     //not doing it
    void amIPrivate() {
        System.out.println("Local Method of derived " + getClass());
    }      //its not overriding , but creating classes own amIPrivate method
    //getClass() doesnt work under static context ??

}

/**
 * Final class
 */
final class FinalClass {
    public static void show() {
        System.out.println("Show public final class ");
    }

    final void a() {
    }        //valid but illogical to put final here
}

//class Temp3 extends FinalClass{ }     //cannot inherit from a final class


public class FinalFamily {
    static {
        System.out.println("static block is invoked");
    }

    public static void main(String[] args) {
        System.out.println("Main");

        FinalData a = new FinalData();

        FinalMethods f1 = new Temp2();

        //f1.amIPrivate();      //still error as compilers checks for overriden base class method in derived
        //when it doesnt find any it runs private amIPrivate [which is an error]

        f1.change();            //works fine


        Temp2 f2 = new Temp2();
        f2.amIPrivate();        //works fine
        f2.change();            //inherited but cannot be overridden


        FinalClass.show();


    }
}
