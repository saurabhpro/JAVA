package class_design;

abstract class TShirt {
	public TShirt() {
		System.out.print("Starting...");
	}

	abstract int insulate();
}

public class Wardrobe {
	private static void dress() {
		class Jacket extends Sweater { // v1
			int insulate() {
				return 10;
			}
		}

		final TShirt outfit = new Jacket() { // v2
			int insulate() {
				return 20;
			}
		};
		System.out.println("Insulation:" + outfit.insulate());
	}

	public static void main(String... snow) {
		new Wardrobe().dress();
	}

	// make it not static and it fails
	abstract static class Sweater extends TShirt {
		int insulate() {
			return 5;
		}
	}
}