package b_structural.b_bridge.shape2_bridged;

public abstract class Shape {

	protected Color color;

	public Shape(Color color) {
		this.color = color;
	}

	abstract public void applyColor();
}
