package generic.inheritance;

/**
 * Created by Saurabh on 8/13/2015.
 */
class TwoTuple<T, V extends Number> {
	/**
	 * Blank Final Variables
	 * used when you want to provide protection [even in private types
	 * a user can with the help of class reference access them], here user's cannot
	 * re-initialize them once they are initialized inside the constructor
	 */
	public final T first;
	public final V second;


	public TwoTuple(T a, V b) {
		first = a;
		second = b;
	}

	@Override
	public String toString()  //overrides in java.lang.Object which has public toString()
	{
		return "(" + first + "," + second + ")";
	}
}

//T, V are type parameter of generic.inheritance.ThreeTuple sp V must extend Number
class ThreeTuple<T, V extends Number, R> extends TwoTuple<T, V> {
	public final R third;

	public ThreeTuple(T a, V b, R c) {
		super(a, b);
		third = c;
	}

	@Override
	public String toString()  //overrides in java.lang.Object which has public toString()
	{
		return "(" + first + "," + second + "," + third + ")";
	}
}

class Temp {
}

public class GenericInheritance {

	/**
	 * @return anonymous object reference of type generic.inheritance.TwoTuple
	 */
	static TwoTuple<String, Integer> f() {
		return new TwoTuple<String, Integer>("hi", 47);
	}

	/**
	 * @return anonymous object reference of type generic.inheritance.ThreeTuple
	 * Double is subclass of Number So Allowed
	 */
	static ThreeTuple<Temp, Double, String> g() {
		return new ThreeTuple<>(new Temp(), 48.9, "hi");
	}

	public static void main(String[] args) {
		TwoTuple<String, Integer> tOb = f();
		System.out.println(tOb); //automatically calls tOb.toString()
		System.out.println(g());
	}
}
