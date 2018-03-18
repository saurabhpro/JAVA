/*
 * Copyright (c) 2018 Saurabh Kumar
 */

/**
 * Created by Saurabh on 8/29/2015.
 */

class LegalIdentifiers {
	//int a =  _555 ;    invalid
	//int a2 = 555_ ;    invalid
	//int c = 76,87897;  invalid
	//int #sum1 = 44;    invalid

	int b;
	int $sum = 55;      //valid

	LegalIdentifiers() {
		System.out.println("before" + b);
		b = 4_6664;         //valid
		System.out.println("after" + b);

	}

	public void IdentifiersAndKeywords() {
	}

	//same name as constructor but its a method

	void show() {
		System.out.println(b);
	}

	void setB(int i) {
		b = i;
	}

	void set$sum(int i) {
		$sum = i;
	}


}

class PassByCopy {
	static int g;
	int c;
	LegalIdentifiers l2;


}

class TypeDemotion {

	int Int;
	float Float;
	//in bytecode this is considered as   float Float = 9.0F;
	long Long;
	double Double;
	char Char;
	byte Byte;

	TypeDemotion() {
		Int = 8;
		Float = 6.9f;        //sirf 6.9 will give ERROR so suffix f

		Long = 11;
		Double = 10;
		Char = (char) -98;
		Byte = 127;
		//Byte = 128 (error as this is now out of range so int consider karega)
	}


	void checkForEquality() {
		if (Float == 6.9)        //  if((double)this.Float == 6.9D)
			System.out.println("Float and Double Same");
		else
			System.out.println("Float and Double Not Same");


		Float = 9223372036854775807L;       //surprisingly this is fine, isse jada digits me nhi karega
		Float = java.lang.Long.MAX_VALUE;   //bytecode 9.223372E18F;

		System.out.println(java.lang.Long.MAX_VALUE + "\nFloat se : " + (long) Float);

		// java.lang.Float.MAX_VALUE = 3.4028235 x 10^38
		System.out.println(java.lang.Float.MAX_VALUE + java.lang.Float.MAX_VALUE);   //Infinity o/p
		System.out.println(java.lang.Float.MAX_VALUE + 85);   //o/p equal to Float.MAX_VALUE as insignificant value added

		//but here it gets strange
		System.out.println(java.lang.Float.MIN_VALUE);      //its positive 1.4 x 10^-45
		System.out.println(java.lang.Float.MIN_VALUE - 1);
/*
        Float.MIN_VALUE is a really small number, not a negative number: 1.4E-45
        0.00000000000000000000000000000000000000000000014 (again I may have typed the wrong number of zeroes)

        That number is really insignificant compared to a float with value -1.0.
        0.00000000000000000000000000000000000000000000014 - 1 = -1.0
*/
	}
}

public class Fundamentals {

	public static void main(String[] args) {
		LegalIdentifiers lOb = new LegalIdentifiers();
		lOb.setB(54);


		System.out.println(new Fundamentals().main(5, 3));
		lOb.show();


		TypeDemotion tOb = new TypeDemotion();
		tOb.checkForEquality();
	}

	int main(int base, int pow) {
		if (pow == 0)
			return 1;
		else
			return base * main(base, (pow - 1));
	}

	//overloading main just like any other function
	int main(int n) {
		return 0;
	}
}
