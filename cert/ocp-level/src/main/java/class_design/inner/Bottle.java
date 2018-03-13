package class_design.inner;

public class Bottle {
	public static void main(String[] stars) {
		Bottle bottle = new Bottle();
		Ship q = new Bottle.Ship(); // w2 and not bottle.new Ship()
		System.out.print(q.getSail().getHeight());
	}

	public static class Ship {

		public Sail getSail() {
			return Sail.TALL;
		}

		private enum Sail { // w1
			TALL {
				@Override
				protected int getHeight() {
					return 100;
				}
			}, SHORT {
				@Override
				protected int getHeight() {
					return 2;
				}
			};

			protected abstract int getHeight();
		}
	}
}
