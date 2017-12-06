package arrayList;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

class EMyMethods {
	static String name = "m1";
	float o;

	public static void main(String[] args) {
		EMyMethods m1 = new EMyMethods();
		m1.riverRafting();

		m1.tes("ii", "ii");
		m1.o = 9;
		//System.out.println(Integer.valueOf(null));
		EMyMethods mi;

		List<Integer> sizes = new ArrayList<>();
		sizes.add(null);
		int firstSize = sizes.get(0);
		System.out.println(firstSize);


//		String ejgStr[] = new String[][]{{null}, new String[]{"a", "b", "c"}, {new String()}}[0];
//		String ejgStr1[] = null;
//		String ejgStr2[] = {null};
//		System.out.println(ejgStr[0]);
//		System.out.println(ejgStr2[0]);
//		System.out.println(ejgStr1[0]);


		byte b = 0b0101;
		System.out.println(b);
		StringBuilder sb1 = new StringBuilder("eLion");
		String ejg = null;
		ejg = sb1.append("X").substring(sb1.indexOf("L"), sb1.indexOf("X"));
		System.out.println(ejg);


		LocalDate day = LocalDate.of(2015, Month.MAY, 27);
		day.plusDays(30);
		System.out.println(day);


		char[] charArray = {'e', 's', 'p', 'r', 'e', 's', 's', 'o', '8', '9', '0'};
		System.arraycopy(charArray, 2, charArray, 6, 5);
		System.out.println(charArray[8]);

		ArrayList<String> names = new ArrayList<>(2);
		names.add("Amy");
		names.add("Anne");
		names.add("Jason");
		System.out.println(names.get(3));

	}

	void riverRafting() {
		String name = "m2";
		if (8 > 2) {
			//String name = "m3";
			System.out.println(name);
		}
	}

	void tes(String... oo) {
	}
}
