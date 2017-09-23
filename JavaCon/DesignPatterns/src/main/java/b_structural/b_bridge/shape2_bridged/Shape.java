package b_structural.b_bridge.shape2_bridged;

abstract class Shape {

	final Color color;

	Shape(Color color) {
		this.color = color;
	}

	abstract public void applyColor();
}
