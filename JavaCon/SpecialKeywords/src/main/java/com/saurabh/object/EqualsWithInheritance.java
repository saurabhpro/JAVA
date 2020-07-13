/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package com.saurabh.object;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Objects;

enum Color {
    RED
}

public class EqualsWithInheritance {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        System.out.println("p.eq.cp = " + p.equals(cp));
        //System.out.println("cp.eq.p = " + cp.equals(p));

        // The equals implementation for Timestamp does violate symmetry and can cause erratic behavior
        // if Timestamp and Date objects are used in the same collection or are otherwise intermixed.
        Date date = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
        java.sql.Timestamp tr = Timestamp.from(date.toInstant());

        System.out.println(date + "\n" + tr);
        System.out.println(date.equals(tr) + "\n" + tr.equals(date));
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColorPoint that = (ColorPoint) o;

        return Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
