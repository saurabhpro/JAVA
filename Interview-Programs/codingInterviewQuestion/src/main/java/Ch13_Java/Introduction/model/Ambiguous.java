package Ch13_Java.Introduction.model;

public class Ambiguous implements Shape {
    @SuppressWarnings("FieldCanBeLocal")
    private final double area = 10;

    public double computeArea() {
        return area;
    }
}
