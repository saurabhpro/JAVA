package class_design;

abstract public class Shape {

	private static int staticVar = 66;
	private static int instanceVar = 68;

	// outsider class method accessing inner class private variable
	void showRedColorStrength() {
		System.out.println("White color has red values:" + new Color().m_red);
	}

	public static class Color {
		private int m_red, m_green, m_blue;

		public Color() {
			// call the other overloaded Color constructor by passing default values
			this(0, 0, 0);
		}

		public Color(int red, int green, int blue) {
			m_red = red;
			m_green = green;
			m_blue = blue;

			System.out.println(staticVar);  // invalid to use this.staticVar or super.staticVar since both are after instance
			// cannot use outside instanceVar since class is static
		}

		public String toString() {
			return " red = " + m_red + " green = " + m_green + " blue = " + m_blue;
		}
		// other color members elided
	}

	public class InnerOnly extends Color {
		// inner class can be extended here

		InnerOnly() {
			System.out.println(instanceVar);    // also not possible to user this. or super. but class is non-static so access possible
		}
	}

	// other Shape members elided (omitted)

	public class InnerExended extends Shape.InnerOnly {
		// Non-Static inner can be extened here since that's in the scope

		// cannot create static this in inner class
		// static int in = 9;
		// static void show(){}
	}
}


class ExtendingStaticInnerClass extends Shape.Color {
	// static inner class extended here
	// note: Non-Static inner cannot be extended like this
}

class TestColor {
	public static void main(String[] args) {
		// since Color is a static nested class,
		// we access it using the name of the outer class, as in Shape.Color
		// note that we do not (and cannot) instantiate Shape class for using Color class
		Shape.Color white = new Shape.Color(255, 255, 255);
		System.out.println("White color has values:" + white);

		//System.out.println("White color has red values:" + white.red); // red is private here since different class
	}
}