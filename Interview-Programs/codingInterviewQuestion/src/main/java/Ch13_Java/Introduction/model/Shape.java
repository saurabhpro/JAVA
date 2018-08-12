package Ch13_Java.Introduction.model;

public interface Shape {
    default void printMe() {
        System.out.println("I am a shape.");
    }

    double computeArea();
}
