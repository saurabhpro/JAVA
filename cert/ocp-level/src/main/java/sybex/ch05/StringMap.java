package sybex.ch05;

public class StringMap {
	public static void main(String[] args) {
		String st1 = new String("S1");
		String st2 = new String(st1);
		String st3 = new String(new String("S1"));// same as above ->


		System.out.println(st1 == st2);
		System.out.println(st1.equals(st2));
		System.out.println(st3.equals("S1"));


		String s = "abcde ";
		System.out.println(s.trim().length());                      //  5
		System.out.println(s.charAt(4));                            //  e
		System.out.println(s.indexOf('e'));                         //  4
		System.out.println(s.indexOf("de"));                        //  3
		System.out.println(s.substring(2, 4).toUpperCase());        //  CD (as string)
		System.out.println(s.replace('a', '1'));   //  1bcde
		System.out.println(s.contains("DE"));                       //  false
		System.out.println(s.startsWith("a"));                      //  true


		StringBuilder b = new StringBuilder();
		b.append(12345).append('-');

		System.out.println(b);
		b.reverse();
		System.out.println(b);

		b = new StringBuilder(4);
		System.out.println(b.capacity());

		b = new StringBuilder("abcd");
		System.out.println(b + "" + b.capacity());

		b.delete(0, 4);
		System.out.println(b + "" + b.capacity());

		b.trimToSize();
		System.out.println(b + "" + b.capacity());

	}
}
