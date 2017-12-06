package random;

public class StaticVariables {
	private static boolean test = false;

	public static void main(String[] args) {
		System.out.println(test);
		test = doStuff();
		System.out.println(test);
	}

	private static boolean doStuff() {
		return !test;
	}
}
