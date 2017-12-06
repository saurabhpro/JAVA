package data_type;

public class DataType {
	public static void main(String[] args) {

		double fm = 6.1 % 3.0;
		System.out.println(fm);

		int in = -8 % 3;
		System.out.println(in);

		double d1 = 29.81;
		//float f1 = 2.11; is error
		float f1 = 2.11f;

		float f = 234.567F;
		short s = (short) f;
		System.out.println(s);

		byte b = 12;
		System.out.println(b);
		// b = 128 error
		b = 127;   // compiler agrees that its ok

		int a = ~4;

		System.out.println(Integer.toString(4, 2));
		System.out.println(Integer.toBinaryString(a));
		System.out.println(!true);


		short s1 = 5;
		short s2 = 9;

		//short s3 = s1 + s2; // its an int result case


		long x = 10;
		int y = 5;
		//y = y * x; // DOES NOT COMPILE

		//This last line could be fixed with an explicit cast to (int), but there’s a better way using the compound assignment operator:
		y *= x; //COMPILES

		//The compound operator will first cast x to a long, apply the multiplication of two long values, and then cast the result to an int. U

		long y0 = (x = 3);
		System.out.println(x); // Outputs 3  // result of the assignment is an expression in and of itself, equal to the value of the assignment.
		System.out.println(y0); // Also, outputs 3


		// CRAZZY RIGHT
		int i1 = new Integer(5);
		Integer i2 = Integer.valueOf("55");
		System.out.println(i2.byteValue());

		booleanInitializer();

		int oo = 4;
		System.out.println("Yo " + (oo * 4 - oo++));
		System.out.println(oo + oo < 10 ? "Too few" : "Too many");

		System.out.println(10 * (5 + 8) % (132 - 2) ^ 7); // 0 ^ 7 -> 0000 ^ 0111 -> 0111 -> 7

		int salesPhone = 1;
		System.out.println(salesPhone++ + ++salesPhone + ++salesPhone);

		if (7 == 7.0) System.out.println("works");
		if (65 == 'A') System.out.println("works");
		if (65.0f == 'A') System.out.println("works");

		if (true | false ^ false) System.out.println("should be true ? Obviously");
		if (true ^ false & false) System.out.println("should be true ? Obviously");


		int io = 9;
		int r = ++io + io++ + io++;
		// 10 + 10 + 11
		System.out.println(r);

		io = 9;
		r = io++ + ++io + io++ + ++io;
		// 9 + 11 + 11 + 13
		System.out.println(r);
	}

	private static void booleanInitializer() {
		Boolean b = Boolean.valueOf("truE");
		System.out.println("truE : " + b);

		b = Boolean.valueOf("truEsss");
		System.out.println("truEsss : " + b);

		// both variants call parseBoolean(String)v internally => ((s != null) && s.equalsIgnoreCase("true"))
		boolean bol = Boolean.valueOf(null);
		System.out.println("Boolean.valueOf(null) = " + bol);
		bol = new Boolean(null);
		System.out.println("new Boolean(null) = " + bol);
	}
}


