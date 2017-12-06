package data_type.ternary;

public class TernaryTypeProblems {
	public static String travel(int distance) {
		//return distance < 1000 ? "train" : 10;

		float d = 12_34.01 >= 123_4.00 ? 123 : 765.05f;
		System.out.println("12_34.01 >= 123_4.00 ? 123 : 765.05f = " + d);

		return null;
	}

	public static void main(String[] answer) {
		System.out.print("sout(null) = " + travel(500));
	}
}
