package Introduction.Big_O;

public class Q_04 {

	private static int div(int a, int b) {
		int count = 0;
		int sum = b;
		while (sum <= a) {
			sum += b;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(div(12, 4));
	}

}
