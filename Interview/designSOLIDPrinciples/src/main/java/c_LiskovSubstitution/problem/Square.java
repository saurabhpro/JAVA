package c_LiskovSubstitution.problem;

/**
 * Square class; Square inherits from Rectangle;
 * Represents IS-A relationship - Square is a Rectangle
 */
public class Square extends Rectangle {
	@Override
	public void setBreadth(int breadth) {
		super.setBreadth(breadth);
		super.setLength(breadth);
	}

	@Override
	public void setLength(int length) {
		super.setLength(length);
		super.setBreadth(length);
	}
}