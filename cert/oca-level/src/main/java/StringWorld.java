public class StringWorld {
	public static void main(String[] args) {
		String se = "Kubernet";
		se = se.substring(3, se.length());
		System.out.println(se);

		String s = "Hello";
		String t = new String(s);
		if ("Hello".equals(s)) System.out.println("one");
		if (t == s) System.out.println("two");
		if (t.equals(s)) System.out.println("three");
		if ("Hello" == s) System.out.println("four");
		if ("Hello" == t.intern()) System.out.println("five");

		String s1 = "Java";
		String s2 = "Java";
		StringBuilder sb1 = new StringBuilder();
		sb1.append("Ja").append("va");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(sb1.toString() == s1);
		System.out.println(sb1.toString().equals(s1));

		String s5 = "i" + 'o' + false;
		System.out.println(s5);


		StringBuilder sbt = new StringBuilder("test"); // makes capacity 4 + 16
		sbt = new StringBuilder(5);// makes capacity 5
		//capacity once alloted remains , so won't decrease if delete is called
		System.out.println(sbt.capacity());

		// Say Whaat ???
		StringBuilder sb = new StringBuilder("HI ");
		sb.append(" LOve", 2, 4);
		System.out.println(sb); // HI Ov

		StringBuilder builder = new StringBuilder("54321");
		builder.substring(2);
		System.out.println(builder.charAt(1));

		StringBuilder sb3 = new StringBuilder("radical ").delete(1, 100)
				.append("obots")
				.insert(1, "adical r");

		System.out.println(sb3);

		System.out.println(sb3.insert(sb3.length(), " O"));


		String a = "";
		a += 2;
		a += 'c';
		a += false;
		if (a == "2cfalse") System.out.println("==");       // is false :P
		if (a.equals("2cfalse")) System.out.println("equals");
		System.out.println("See: " + a.getClass().toGenericString());   // See: public final class java.lang.String

	}
}
