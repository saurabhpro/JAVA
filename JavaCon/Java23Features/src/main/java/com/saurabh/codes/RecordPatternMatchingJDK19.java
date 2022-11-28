package com.saurabh.codes;

import static com.saurabh.codes.RecordPatternMatchingJDK19.Color.GREEN;
import static com.saurabh.codes.RecordPatternMatchingJDK19.Color.RED;

public class RecordPatternMatchingJDK19 {

    record Point(int x, int y) {

    }

    enum Color {RED, GREEN, BLUE}

    record ColoredPoint(Point p, Color c) {

    }

    record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {

    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(
            new ColoredPoint(new Point(1, 2), RED),
            new ColoredPoint(new Point(13, 14), GREEN)
        );
        printUpperLeftColoredPoint(rectangle);
        printColorOfUpperLeftPoint(rectangle);
    }

    static void printUpperLeftColoredPoint(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint ul,ColoredPoint lr)) {
            System.out.println(ul.c() + " " + lr.c());
        }
    }

    // what!!!!
    static void printColorOfUpperLeftPoint(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint(Point p,Color c),ColoredPoint lr)) {
            System.out.println(c);
        }
    }

}
