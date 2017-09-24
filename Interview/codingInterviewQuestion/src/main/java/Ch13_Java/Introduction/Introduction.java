package Ch13_Java.Introduction;

public class Introduction {
	@SuppressWarnings("SameReturnValue")
	private static String lem() {
		System.out.println("lem");
		return "return from lem";
	}

	private static String foo() {
		int x = 0;
		int y = 5;

		try {
			System.out.println("start try");
			//noinspection ConstantConditions,unused
			int b = y / x;
			System.out.println("end try");
			return "returned from try";
		} catch (Exception ex) {
			System.out.println("catch");
			return lem() + " | returned from catch";
		} finally {
			System.out.println("finally");
		}
	}

	private static void bar() {
		System.out.println("start bar");
		String v = foo();
		System.out.println(v);
		System.out.println("end bar");
	}

	public static void main(String[] args) {
		bar();
	}

}
