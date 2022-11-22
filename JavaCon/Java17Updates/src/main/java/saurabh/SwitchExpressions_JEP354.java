package saurabh;

public class SwitchExpressions_JEP354 {

    public static void main(String[] args) {

        System.out.println(getValueBefore14("a"));
        System.out.println(getValueMultipleLabels("c"));
        System.out.println(getValueViaArrow("e"));
        System.out.println(getValueViaYield("z"));

    }

    // Traditional switch
    private static int getValueBefore14(String mode) {
        int result;
        switch (mode) {
            case "a":
            case "b":
                result = 1;
                break;
            case "c":
                result = 2;
                break;
            case "d":
            case "e":
            case "f":
                result = 3;
                break;
            default:
                result = -1;
        }
        ;
        return result;
    }

    // Java 14, multiple comma-separated labels
    private static int getValueMultipleLabels(String mode) {
        int result;
        switch (mode) {
            case "a", "b":
                result = 1;
                break;
            case "c":
                result = 2;
                break;
            case "d", "e", "f":
                result = 3;
                break;
            default:
                result = -1;
        }
        ;
        return result;
    }

    // Java 14, switch expression returning value via label rules (arrow)
    private static int getValueViaArrow(String mode) {
        return switch (mode) {
            case "a", "b" -> 1;     // internally it reads -> { yield 1}
            case "c" -> 2;
            case "e" -> {           // block way of doing things
                System.out.println("Monday");
                yield 3;    // if yield is not given - it won't compile
            }
            case "d", "f" -> 3;
            default -> -1;
        };
    }

    // Java 13, value breaks are superseded by 'yield' statements
    // Java 14, switch expression returning value via yield
    private static int getValueViaYield(String mode) {
        return switch (mode) {
            case "a", "b":
                yield 1;
            case "c":
                yield 2;
            case "d", "e", "f":
                yield 3;
            default:
                yield -1;
        };
    }

}
