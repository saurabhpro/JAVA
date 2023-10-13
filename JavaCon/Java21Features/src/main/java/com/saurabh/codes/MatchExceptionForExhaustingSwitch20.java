package com.saurabh.codes;

public class MatchExceptionForExhaustingSwitch20 {

    record Position(int x, int y) {

    }

    public sealed interface Shape permits Rectangle, Circle {

    }

    public record Rectangle(Position topLeft, Position bottomRight) implements Shape {

    }

    public record Circle(Position center, int radius) implements Shape {

    }

    public static void main(String[] args) {
        var rectangle = new Rectangle(new Position(10, 10), new Position(50, 50));
        ShapeDebugger.debug(rectangle);

        var circle = new Circle(new Position(30, 30), 10);
        ShapeDebugger.debug(circle);
    }

    public class ShapeDebugger {

        public static void debug(Shape shape) {
            // this switch expects all permitted class list
            switch (shape) {
                case Rectangle r -> System.out.println(
                    "Rectangle: top left = " + r.topLeft() + "; bottom right = " + r.bottomRight());

                case Circle c -> System.out.println(
                    "Circle: center = " + c.center() + "; radius = " + c.radius());
            }
        }
    }

}
