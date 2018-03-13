package class_design.local;

public class Woods {
	public static void main(String[] leaves) {
		int water = 10 + 5;

		final class Oak extends Tree { // p1
			public int getWater() {
				return water; // p2
			}
		}

		System.out.print(new Oak().getWater());
	}

	static class Tree {
	}
}