package generics;

/**
 * Created by Saurabh on 8/13/2015.
 */
public class OnlyGenericMethods {

	private static <T> void showVal1(T x) {
		System.out.println(x);
		System.out.println(x.getClass().getName() + "\n");

	}

	private static <T extends Number> void showVal2(T x) {
		System.out.println(x);
		System.out.println(x.getClass().getName() + "\n");

	}

	public static void main(String[] args) {
		OnlyGenericMethods gm = new OnlyGenericMethods();

		gm.showType("");
		gm.showType(76);    //autoboxing Automatic Type Inference

		showVal1("Hello");
		OnlyGenericMethods.showVal2(96.8f);     //static method

		/*
		showVal2("Hello");

        Error:(21, 9) java: method showVal2 in class generics.OnlyGenericMethods cannot be applied to given types;
          required: T
          found: java.lang.String
          reason: inferred type does not conform to upper bound(s)
            inferred: java.lang.String
            upper bound(s): java.lang.Number
         */
	}

	private <T> void showType(T x) {
		System.out.println(x);
		System.out.println(x.getClass().getName() + "\n");
	}

}
