/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Interface.diamondProblem;

/**
 * This presents something of a dilemma because it’s not immediately obvious whether ApplicationFacade should inherit
 * the default implementation of deactivate() from the ApplicationManager class, and becomes even more complex
 * if ResourceController also defines its deactivate() method to have a default method. In that scenario we will
 * have defined a class that inherits from two different interfaces, each with its own implementation of deactivate().
 * <p>
 * Java 8 addresses this by requiring you to provide an implementation for the ambiguous method in the relevant class,
 * in this case ApplicationFacade. In fact, if you try to compile the foregoing code you’ll receive a message
 * like the one shown next.
 */
@SuppressWarnings("SameReturnValue")
@FunctionalInterface
interface DiamondProblemWithDefaultMakesLifeMoreDifficult {

	private static String staticPrivate() {
		return "static private";
	}

	@SuppressWarnings("unused")
	static void checkThis() {
		//approach 1
		String result = staticPrivate();
		System.out.println(result);

		//approach 2
		// anonymous class
		DiamondProblemWithDefaultMakesLifeMoreDifficult pvt = () -> {  /*just to show what we want to do*/ };
		result = pvt.instancePrivate();
		System.out.println(result);

		//approach 3 - doesn't work obv
		/*result = instancePrivate();
		System.out.println(result);*/
	}

	private String instancePrivate() {
		return "instance private";
	}

	@SuppressWarnings("unused")
	default void check() {
		//approach 1
		String result = staticPrivate();
		System.out.println(result);

		//approach 2
		@SuppressWarnings({"Convert2Lambda", "unused"})
		DiamondProblemWithDefaultMakesLifeMoreDifficult pvt = new DiamondProblemWithDefaultMakesLifeMoreDifficult() {
			@SuppressWarnings("unused")
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

interface SecondFile extends DiamondProblemWithDefaultMakesLifeMoreDifficult {
	default void check() {
		/*approach 1 - doesn't work since protected isn't available and private wont allow it
		String result = staticPrivate();
		System.out.println(result);
		*/

		//approach 2
		@SuppressWarnings({"Convert2Lambda", "unused"})
		DiamondProblemWithDefaultMakesLifeMoreDifficult pvt = new DiamondProblemWithDefaultMakesLifeMoreDifficult() {
			@SuppressWarnings("unused")
			@Override
			public void thisOneMakeItFI() {
				System.out.println("just to show what we want to do");
			}
			// anonymous class
		};
		pvt.thisOneMakeItFI();

	}
}

interface ThirdFile extends SecondFile {
	default void check() {
		/*approach 1 - doesn't work since protected isn't available and private wont allow it
		String result = staticPrivate();
		System.out.println(result);
		*/

		//approach 2
		DiamondProblemWithDefaultMakesLifeMoreDifficult pvt = () -> System.out.println("just to show what we want to 77");
		pvt.thisOneMakeItFI();

	}
}

class Tester implements SecondFile, DiamondProblemWithDefaultMakesLifeMoreDifficult, ThirdFile {

	public static void main(String[] args) {
		Tester tester = new Tester();
		tester.thisOneMakeItFI();
		//tester.check();
	}

	@Override
	public void thisOneMakeItFI() {
		System.out.println("Lonely implementation");
		check();    //which one you ask ?
	}
}