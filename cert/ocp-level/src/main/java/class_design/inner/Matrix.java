package class_design.inner;

public class Matrix {
	private int level = 1;

	public static void main(String[] bots) {
		Matrix.Deep.Deeper simulation = new Matrix().new Deep().new Deeper();
		simulation.printReality();
	}

	class Deep {
		private int level = 2;

		class Deeper {
			private int level = 5;

			public void printReality() {
				System.out.print(level);
				System.out.print(" " + Matrix.Deep.this.level);
				System.out.print(" " + Deep.this.level);
			}
		}
	}
}

class Penguin {
	private static int volume = 1;

	public static void main(String... eggs) {
		Penguin pen = new Penguin();
		final Penguin.Chick littleOne = pen.new Chick();
		littleOne.chick();
	}

	private class Chick {
		private int volume = 3;

		void chick() {
			System.out.print("Honk(" + Penguin.this.volume + ")!");
		}
	}
}

class Ready {
	protected static int first = 2;
	private final short DEFAULT_VALUE = 10;
	private GetSet go = new GetSet();

	public static void main(String[] begin) {
		Ready r = new Ready();
		System.out.print(r.go.first);
		//	System.out.print(", " + r.go.second);
	}

	private static class GetSet {
		int first = 5;
		// static int second = Ready.this.DEFAULT_VALUE;
	}
}