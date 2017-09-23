package saurabh.Interface.Java9;

@SuppressWarnings("ALL")
@FunctionalInterface
interface InterfaceWithPrivateMethods {

	private static String staticPrivate() {
		return "static private";
	}

	static void checkThis() {
		//approach 1
		String result = staticPrivate();
		System.out.println(result);

		//approach 2
		// anonymous class
		InterfaceWithPrivateMethods pvt = () -> {  /*just to show what we want to do*/ };
		result = pvt.instancePrivate();
		System.out.println(result);

		//approach 3 - doesn't work obv
		/*result = instancePrivate();
		System.out.println(result);*/
	}

	private String instancePrivate() {
		return "instance private";
	}

	default void check() {
		//approach 1
		String result = staticPrivate();
		System.out.println(result);

		//approach 2
		//noinspection Convert2Lambda
		InterfaceWithPrivateMethods pvt = new InterfaceWithPrivateMethods() {
			@Override
			public void thisOneMakeItFI() {
				//just to show what we want to do
			}
			// anonymous class
		};
		result = pvt.instancePrivate();
		System.out.println(result);

		//approach 3
		result = instancePrivate();
		System.out.println(result);
	}

	void thisOneMakeItFI();
}

class Tester implements InterfaceWithPrivateMethods {

	public static void main(String[] args) {
		Tester tester = new Tester();
		tester.thisOneMakeItFI();
		tester.check();

		//Tester.checkThis(); is not possible
		InterfaceWithPrivateMethods.checkThis();
	}

	@Override
	public void thisOneMakeItFI() {
		System.out.println("Lonely implementation");
	}
}