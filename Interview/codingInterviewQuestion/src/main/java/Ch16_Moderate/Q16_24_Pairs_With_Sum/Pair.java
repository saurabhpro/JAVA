package Ch16_Moderate.Q16_24_Pairs_With_Sum;

class Pair {
	private final int first;
	private final int second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}
