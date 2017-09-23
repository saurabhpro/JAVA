package saurabh.Interface.diamondProblem;

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