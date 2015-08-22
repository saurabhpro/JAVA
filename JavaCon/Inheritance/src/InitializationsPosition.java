/**
 * Created by Saurabh on 8/17/2015.
 */
class X{}

public class InitializationsPosition {

    /* At the place of initialization*/
    private int x = 9;
    X xOb1 = new X();

    /*instance initialization*/
    private int y ;
    {
        y = 10;
    }

    /*Inside constructor*/
    private int z;
    InitializationsPosition(int tmp)
    {
        z=tmp;
    }

    /*Lazy Inialization => in functions where we want to use them*/

    private String first, second;   //by default null as object
    private int value;              //by default 0  [already]
    X xOb2 ;                        //by default null

    public String toString()
    {
        System.out.println(xOb2);

        if(xOb2 == null)            xOb2 = new X();
        if(first == null)            first = "Hello";
        if(second == null)            second = "World";
        if (value==0)   value = 99;

        return xOb2+" "+first+" "+second+" "+value;
    }

    //main method
    public static void main(String[] args) {
        InitializationsPosition iOb = new InitializationsPosition(88);
        System.out.println(iOb);    //implicitly calls toString()
    }

}
