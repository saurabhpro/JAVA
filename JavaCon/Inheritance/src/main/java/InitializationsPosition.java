/**
 * Created by Saurabh on 8/17/2015.
 */
class X {
}

@SuppressWarnings("ALL")
public class InitializationsPosition {

	/*instance initialization*/
	private final int y;
	X xOb1 = new X();
	private X xOb2;                        //by default null
	/* At the place of initialization*/
	private int x = 9;
	/*Inside constructor*/
	private int z;
	private String first, second;   //by default null as object

	/*Lazy Inialization => in functions where we want to use them*/
	private int value;              //by default 0  [already]

	{
		y = 10;
	}

	private InitializationsPosition(int tmp) {
		z = tmp;
	}

	//main method
	public static void main(String[] args) {
		InitializationsPosition iOb = new InitializationsPosition(88);
		System.out.println(iOb);    //implicitly calls toString()
	}

	public String toString() {
		System.out.println(xOb2);

		if (xOb2 == null) xOb2 = new X();
		if (first == null) first = "Hello";
		if (second == null) second = "World";
		if (value == 0) value = 99;

		return xOb2 + " " + first + " " + second + " " + value;
	}

}
