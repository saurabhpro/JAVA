package com.saurabh.java;

import static java.lang.StringTemplate.RAW;
import static java.util.FormatProcessor.FMT;

public class StringLiteralJDK21 {

    public static void main(String[] args) {
        strTemplateProcessor();
        formatterTemplateProcessor();
    }

    private static void formatterTemplateProcessor() {
        record Rectangle(String name, double width, double height) {

            double area() {
                return width * height;
            }
        }
        final var zone = new Rectangle[]{
            new Rectangle("Alfa", 17.8, 31.4),
            new Rectangle("Bravo", 9.6, 12.4),
            new Rectangle("Charlie", 7.1, 11.23),
            };

        final var table = FMT."""
            Description     Width    Height     Area
            %-12s\{zone[0].name}  %7.2f\{zone[0].width}  %7.2f\{zone[0].height}     %7.2f\{zone[0].area()}
            %-12s\{zone[1].name}  %7.2f\{zone[1].width}  %7.2f\{zone[1].height}     %7.2f\{zone[1].area()}
            %-12s\{zone[2].name}  %7.2f\{zone[2].width}  %7.2f\{zone[2].height}     %7.2f\{zone[2].area()}
            \{" ".repeat(28)} Total %7.2f\{zone[0].area() + zone[1].area() + zone[2].area()}
            """;
        System.out.println(table);
    }

    private static void strTemplateProcessor() {
        final var name = "Baeldung";
        final var welcomeText = STR."Welcome to \{name}";
        System.out.println(welcomeText);

        // when expanded
        final var name2 = "Joan";
        final var st = RAW."My name is \{name2}";
        final var info = STR.process(st);
        System.out.println(info);
    }
}
