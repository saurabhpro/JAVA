package Ch16_Moderate.Q16_03_Intersection;

class Line {
    public final double slope;
    public final double yintercept;

    public Line(Point start, Point end) {
        double deltaY = end.y - start.y;
        double deltaX = end.x - start.x;
        slope = deltaY / deltaX; // Will be Infinity (not exception) when deltaX = 0
        yintercept = end.y - slope * end.x;
    }

    public void print() {
        System.out.print("y = " + slope + "x + " + yintercept);
    }
}