package class_design.local;

import class_design.inner.Shape;

public class StatusReporter {

	// important to note that the argument "color" is declared final, since jdk1.7 not needed to be final - just effective final

	static Shape.Color getDescriptiveColor(final Shape.Color color) {

		// local inner classes can only user effective final variable from method scope

		int a = 6;  // effectively final

		// local class DescriptiveColor that extends Shape.Color class
		/*
		 * They do not have an access specifier.
		 * They cannot be declared static and cannot declare static fields or methods.
		 * They have access to all fields and methods of the enclosing class.
		 * They do not have access to local variables of a method unless those variables are final or effectively final.
		 */
		class DescriptiveColor extends Shape.Color {

			public void show() {
				System.out.println(a);
			}

			public String toString() {
				return "You selected a color with RGB values" + color;
			}
		}
		// color = null;   // if you do this the effective final is no longer valid since we changed it

		return new DescriptiveColor();
	}

	public static void main(String[] args) {
		Shape.Color descriptiveColor = StatusReporter.getDescriptiveColor(new Shape.Color(0, 0, 0));

		System.out.println(descriptiveColor);
	}
}