package Ch13_Java.Introduction.model;

public class Circle implements Shape {
    @SuppressWarnings("FieldCanBeLocal")
    private final double rad = 5;

    public void printMe() {
        System.out.println("I am a circle.");
    }

    public double computeArea() {
        return rad * rad * 3.15;
    }
}
