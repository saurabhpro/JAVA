package Ch16_Moderate.Q16_13_Bisect_Squares;

public class Point {
	public final double x;
	public final double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public boolean isEqual(Point p) {
		return (p.x == x && p.y == y);
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
