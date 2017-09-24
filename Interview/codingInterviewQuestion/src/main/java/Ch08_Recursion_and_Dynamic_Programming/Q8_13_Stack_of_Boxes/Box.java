package Ch08_Recursion_and_Dynamic_Programming.Q8_13_Stack_of_Boxes;

class Box {
	public final int height;
	private final int width;
	private final int depth;

	public Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;
	}

	public boolean canBeUnder(Box b) {
		if (width > b.width && height > b.height && depth > b.depth) {
			return true;
		}
		return false;
	}

	public boolean canBeAbove(Box b) {
		if (b == null) {
			return true;
		}
		if (width < b.width && height < b.height && depth < b.depth) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "Box(" + width + "," + height + "," + depth + ")";
	}
}
