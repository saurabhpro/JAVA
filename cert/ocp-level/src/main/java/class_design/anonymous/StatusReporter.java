package class_design.anonymous;

import class_design.inner.Shape;

class StatusReporter {

	// same thing effective final works
	static Shape.Color getDescriptiveColor(Shape.Color color) {

		// note the use of anonymous inner classes here
		// -- specifically, there is no name for the class and we construct
		// and use the class "on the fly" in the return statement!

		// local inner class has a name, whereas an anonymous inner class does not - and that’s the main difference.
		// also, You cannot explicitly extend a class or explicitly implement interfaces when defining an anonymous class.
		return new Shape.Color() {
			public String toString() {
				return "You selected a color with RGB values" + color;
			}
		};
	}

	public static void main(String[] args) {
		Shape.Color descriptiveColor = StatusReporter.getDescriptiveColor(new Shape.Color(0, 0, 0));
		System.out.println(descriptiveColor);
	}
}