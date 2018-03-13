package class_design.enums;

enum DaysOff {
	Thanksgiving, PresidentsDay, ValentinesDay
}

public class Vacation {

	public static void main(String... unused) {
		final DaysOff input = DaysOff.Thanksgiving;
		switch (input) {
			default:
			case ValentinesDay:
				System.out.print("1");
				// case DaysOff.PresidentsDay:  // must be unqualified name
				System.out.print("2");

			case Thanksgiving:
				System.out.print("2");
		}
	}

	// just like interfaces - enums cannot be final or abstract
	enum DaysOff {
		Thanksgiving, PresidentsDay, ValentinesDay
	}
}