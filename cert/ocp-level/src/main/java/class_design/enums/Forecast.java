package class_design.enums;

public class Forecast {
	public static void main(String[] modelData) {
		System.out.println(Snow.BLIZZARD.ordinal());

		System.out.println(" " + Snow.valueOf("flurry".toUpperCase()).getDeclaringClass()); // class class_design.enums.Forecast$Snow
		System.out.print(" " + Snow.valueOf("flurry".toUpperCase()).name());
	}

	public enum Snow {BLIZZARD, SQUALL, FLURRY}
}