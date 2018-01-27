package generics;

import java.util.ArrayList;
import java.util.List;

class Dragon {
}

class Unicorn {
}

/**
 * Mixing of generic and non generic code
 */
public class LegacyDragons {
	public static void main(String[] args) {
		List unicorns = new ArrayList();
		unicorns.add(new Unicorn());
		printDragons(unicorns);
	}

	private static void printDragons(List<Dragon> dragons) {
		for (Dragon dragon : dragons) { // ClassCastException: generics.Unicorn cannot be cast to generics.Dragon
			System.out.println(dragon);
		}
	}
}