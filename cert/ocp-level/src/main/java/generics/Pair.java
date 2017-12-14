package generics;

// This program shows the usage of the diamond syntax when using generics
class Pair<T1, T2> {
	private T1 object1;
	private T2 object2;

	Pair(T1 one, T2 two) {
		object1 = one;
		object2 = two;
	}

	public T1 getFirst() {
		return object1;
	}

	public T2 getSecond() {
		return object2;
	}
}

class TestPair {
	public static void main(String[] args) {
		Pair<Integer, String> worldCup = new Pair<>(2018, "Russia");


		Pair<Integer, String> worldCup2 = new Pair("Boo", "Russia"); //see the problem - no compilation error where it clearly is!

		System.out.println("World cup " + worldCup.getFirst() + " in " + worldCup.getSecond());
	}
}