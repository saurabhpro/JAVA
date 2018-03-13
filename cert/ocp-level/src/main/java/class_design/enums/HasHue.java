package class_design.enums;

enum COLORS implements HasHue {
	red {
		public String getHue() {
			return "FF0000";
		}
	},
	green {
		public String getHue() {
			return "00FF00";
		}
	},
	blue {
		public String getHue() {
			return "0000FF";
		}


	}
}

interface HasHue {
	String getHue();
}

class Book {
	static void main(String[] pencils) {
	}
}

final class ColoringBook extends Book {
	final public static void main(String[] crayons) {
		new ColoringBook().paint(COLORS.green);
	}

	final void paint(COLORS c) {
		System.out.print("Painting: " + c.getHue());
	}
}