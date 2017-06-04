package b_structural.b_bridge.shape2_bridged;

public class Square extends Shape {

	public Square(Color color) {
		super(color);
	}

	@Override
	public void applyColor() {
		color.applyColor();
	}

}
