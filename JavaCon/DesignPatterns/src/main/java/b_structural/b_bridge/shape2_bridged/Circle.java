package b_structural.b_bridge.shape2_bridged;

public class Circle extends Shape {

	public Circle(Color color) {
		super(color);
	}

	@Override
	public void applyColor() {
		color.applyColor();
	}

}
