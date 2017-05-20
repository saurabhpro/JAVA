class You extends Dadaji {
	int x = 30;
	/* this above line works like this in compiler
	int x;
    You()
    {
        x=10;
    }checked by DJ Java decompiler
     */

	void show() {
	}
}

class Dadaji {
	int x = 80;

}


public class SuperClassUpcasted extends You {
	int x = 10;

	//static public void main(String... args){}   // not allowed as just changing order of access types isnt overloading
	public static void main(String a) {
	}          //valid but need to be called explicitly,

	// public static "strictfp/transient/abstract/" void main(String[] args) { } //http://learnwithharsha.com/access-modifiers-in-java/

	public static void main(String... args)     //String... means it has a variable length argument
	        /*java internally compiles it as String []args only so it can accept some variable length argument
	        as parameter

            the three dot stays for vargars. you can access it like a String[].

            If a method takes as paramter a varargs, you can call it with multiple values for the vargars type:

            public void myMethod(String... values) {}
            you can call like myMethod("a", "b");

            in myMethod values[0] is equals "a" and values[1] is equals to "b".

            If you have a method with multiple args, the vargars argument has to be the last: for instance:
            public void myMethod(int first, double second, String... values) {}
             */ {
		SuperClassUpcasted c = new SuperClassUpcasted();
		//c.super.show(); error as not allowed
		c.show();
	}
	// however when code compiles it'll look foe default specification of main i.e below one

	void show() {
		System.out.println(x);

		System.out.println(super.x);

        /*iff there was no 'x' in this class then its base class 'x' could be
        accessed by just using SOP(x) and also by using SOP(super.x)*/

        /* why super.super.x isnt allowed?

        It violates encapsulation. You shouldn't be able to bypass the parent class's behaviour.
        It makes sense to sometimes be able to bypass your own class's behaviour
        (particularly from within the same method) but not your parent's.

         */

		System.out.println(((Dadaji) this).x);       // prints 80
	/*
    However, this doesn't work for method calls because method calls are
    determined based on the runtime type of the object.

     */
	}
}

