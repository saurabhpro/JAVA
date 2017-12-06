package package_ch4_sybex;

public class StaticVariableOfNullReference {
	static int x = 6;

	public static void main(String[] args) {
		StaticVariableOfNullReference ob = new StaticVariableOfNullReference();
		System.out.println(StaticVariableOfNullReference.x);

		ob = null;

		System.out.println(ob.x);   // HOWWW!!! it prints 6 too
	}
}
