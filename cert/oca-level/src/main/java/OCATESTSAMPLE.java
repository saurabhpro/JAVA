import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OCATESTSAMPLE {
	public static void main(String[] args) {
		final String ceiling = "up";
		String floor = new String("up");
		final String wall = new String(floor);
		System.out.println((ceiling == wall) + " " + (floor == wall) + " " + ceiling.equals(wall));


//		char one = Integer.parseInt("1");
//		Character two = Integer.parseInt("2");
		int three = Integer.parseInt("3");
		Integer four = Integer.parseInt("4");
//		short five = Integer.parseInt("5");
//		Short six = Integer.parseInt("6");


		System.out.println(3 == 3);
		System.out.println("bart" == "bart");
		System.out.println(new int[0] == new int[0]);
		System.out.println(LocalTime.now() == LocalTime.now());
		int[] r1 = new int[]{5, 7};
		int[] r2 = new int[]{5, 7};
		System.out.println((r1 == r2) + " " + Arrays.equals(r1, r2));


		List<String> list = new ArrayList<>();
//		list.addAll(2);

		StringBuilder sb = new StringBuilder(5);
		String s = "";

		if (sb.equals(s)) System.out.println("hi");
		else System.out.println("Whaaatt " + sb + "Yo");

		String[] ar = {"Hi", "One", "Two"};
		List<String> integerList = new ArrayList<>(Arrays.asList(ar));
		if (integerList.removeIf((String st) -> st.length() <= 2)) System.out.println("Hy");
		else System.out.println("OO");
		System.out.println(integerList);

		LocalDate ld = LocalDate.of(2017, 12, 5);
		System.out.println(ld.format(DateTimeFormatter.ISO_DATE_TIME)); // UnsupportedTemporalTypeException
	}
}
