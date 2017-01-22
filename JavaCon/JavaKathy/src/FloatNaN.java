import org.jetbrains.annotations.Contract;

/**
 * Created by Saurabh on 11/9/2015.
 */
public class FloatNaN {


	@Contract(pure = true)
	static int squareDivide(int x, int y) {
		int z = x * x / y * y;
		/*you would guess its 64/16 = 4 RIGHT!!!
        but its pass by name

        (4+4)*(4+4)/(2+2)*(2+2);
        =8*8/4*4 = 8*2*4 = 64
        which is crazy isnt it!!!!
         */
		return z;
	}

	public static void main(String[] args) {
		System.out.println(1.0 / 3.0);        //Inexact Exception

		System.out.println(7.6 % 3.5);        //In java % works with floats

		//in java order of execution ensures same answer comes on every machine for these
		int d, a = 1, b = 2;
		d = a++ + ++b;
		System.out.println("a=" + a + " b=" + b + " d=" + d);

		int x = 5, y;
		y = x++ + ++x + ++x + x++ + x++;      //5+7+8+8+9 = 37(correct) but in c => 7*5 =35 (wrong)
		System.out.println("x=" + x + " y=" + y);

		int z, x1 = 7;
		z = x1++ + x1++ + ++x1;             //old c compiler give z=24, new gcc and java give 25
		System.out.println("x1=" + x1 + " z=" + z);

		System.out.println("Func = " + squareDivide((4 + 4), (2 + 2)));
	}
}
