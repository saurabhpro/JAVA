package thinking.in.java;

/**
 * Created by Saurabh on 7/13/2015.
 */
public class Operators {
    void objectEquivalence()
    {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);

        System.out.println(n1==n2);         //false as objects reference are different
        System.out.println(n1.equals(n2));  //true as
    }

    void logicalOp() {
        // System.out.println( 8 && 9 );     In java logical statements only work for bool output
        boolean c, b = false;
    }

    void literals(){
        int i = 012;        //integer is decimal so its converted 2*1 + 1*8 = 10
        //int j = 089;      since we wrote 0 at beginning its octal now, so 8-9 not valid only 0-7
        int j = 077;        //similarly 7*1 + 7*8 = 63
        System.out.println(Long.toBinaryString(i) +" "+ j+ " "+ Integer.toBinaryString(i+j));        //gives output as int
        /*
        12
        77
        ----
      0111      (8=0, 9=1 with carry 1) 1 + 8 + 64 = 73 (answer)
         */
    }

    void typeDemotion()
    {
        //java 8 and above has unsigned int/longs etc. [NO!]
        /*Per the documentation you posted, and this blog post - there's no difference when declaring
        the primitive between an unsigned int/long and a signed one. The "new support" is the addition
        of the static methods in the Integer and Long classes, e.g. Integer.divideUnsigned. If you're
        not using those methods, your "unsigned" long above 2^63-1 is just a plain old long with a negative value.

        From a quick skim, it doesn't look like there's a way to declare integer constants in the range outside of
        +/- 2^31-1, or +/- 2^63-1 for longs. You would have to manually compute the negative value corresponding to
        your out-of-range positive value.*/

        long l = 200;
        int i  = (int) l;       //explicit typcasting works

        float f= Long.MAX_VALUE;             //in case of floats <- long is cast implicitly
        l =(long) f;                         //here explicit cast is required
        //Long.MAX_VALUE = 9223372036854775807  f = 9.223372E18     [note how nothing is lost due to E]
        //if we print l we will get Long.MAX_VALUE only!

        double d = 10.7;
        l = (long)d;
        System.out.println(i+" "+l);    //prints 200 and 10

    }

    void shiftOp()
    {
        byte b1 = 8;
        byte b2 = 9;
        System.out.println(Integer.toBinaryString(b1)+" "+Integer.toBinaryString(b2));
        System.out.println(Integer.toBinaryString(b1>>2));
        System.out.println(Integer.toBinaryString(b2<<2));

        b1 = -16;
        System.out.println(Integer.toBinaryString(b1));
        System.out.println(Integer.toBinaryString(b1>>2));
        System.out.println(Integer.toBinaryString(b1>>>2));

        /*
        11111111111111111111111111110000        //-16
        11111111111111111111111111111100
        00111111111111111111111111111100        [front 0's are not shown on compilers]
         */

        System.out.println(~b1);        //1111 = 15

        b1 = 8;
        b2 = 9;
        System.out.println(Integer.toBinaryString(b1 & b2));
        System.out.println(Integer.toBinaryString(b1 | b2));
        System.out.println(Integer.toBinaryString(16 ^ 12));
        //10000 ^ 01100 = 11100 [odd 1s then 1 , even 1 then 0]


    }

    public static void main(String[] args) {
        Operators obj  = new Operators();
        obj.objectEquivalence();
        obj.literals();
        obj.typeDemotion();
        obj.shiftOp();

        System.out.println();
    }
}


