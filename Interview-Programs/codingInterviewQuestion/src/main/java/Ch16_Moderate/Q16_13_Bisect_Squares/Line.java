package Ch16_Moderate.Q16_13_Bisect_Squares;

public class Line {
    public final Point start;
    public final Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return "Line from " + start.toString() + " to " + end.toString();
    }
}
