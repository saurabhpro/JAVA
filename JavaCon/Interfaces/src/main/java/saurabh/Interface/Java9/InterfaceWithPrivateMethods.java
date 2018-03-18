/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Interface.Java9;

@SuppressWarnings("ALL")
@FunctionalInterface
interface InterfaceWithPrivateMethods {

	/*
	 * Private and Static is allowed for methods - variables can-not be private!!!
	 */
	private static String staticPrivate() {
		return "static private";
	}

	/*
	 * static private is allowed to allow methods to directly use it
	 */
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

	/*
	 * We can mix default + private (since default in itself is a access specifier
	 * so we can create simpler private methods just like in classes
	 */
	private String instancePrivate() {
		return "instance private";
	}

	/*
	 * As said - can't mix private + default
	 */
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