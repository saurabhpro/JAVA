/**
 * Created by Saurabh on 8/17/2015.
 */
public class StaticFamily {
	static int i = 10;
	static int j = 20;

	static {
		m1();
		System.out.println("first block");
	}

	static {
		System.out.println("second block");
	}

	public static void main(String[] args) {
		System.out.println("Main method");
	}

	public static void m1() {
		System.out.println(j);
	}

}