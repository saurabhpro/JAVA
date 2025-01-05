package com.saurabh.java;

public class UnnamedPatternVariable {

    record Car(String name, String color, String mileage) {

        Car(String name) {
            this(name, "Red", "100k");
        }
    }

    public static void main(String[] args) {

        final var car = new Car("tesla");
        try {
            throw new IllegalArgumentException("test");
        } catch (IllegalStateException _) {
//            System.out.println("Got an illegal state exception for: \{car.name()}");
        } catch (RuntimeException _) {
            System.out.println("Got a runtime exception!");
        }

        final var color = getObjectsColorWithUnnamedPattern(car);
        System.out.println(color);

        System.out.println(getObjectsColorWithSwitchAndUnnamedPattern(car));
    }

    static String getObjectsColorWithUnnamedPattern(Object object) {
        if (object instanceof Car(_, var color, _)) {
            return color;
        }
        return "No color!";
    }

    static String getObjectsColorWithSwitchAndUnnamedPattern(Object object) {
        return switch (object) {
            case Car(_, var color, _) -> color;
            default -> "No color!";
        };
    }
}
