package strings;

import java.util.function.Predicate;

class ConsonantsVowel {

    private static Predicate<String> isAplha = c -> c.matches("[a-zA-Z]");

    private static Predicate<String> isVowel =
            c -> c.equalsIgnoreCase("a") ||
                    c.equalsIgnoreCase("e") ||
                    c.equalsIgnoreCase("i") ||
                    c.equalsIgnoreCase("o") ||
                    c.equalsIgnoreCase("u") ||
                    c.equalsIgnoreCase("y");

    static long countVowels(String input) {

        return input.chars()
                .peek(System.out::println)
                .mapToObj(c -> String.valueOf((char) c))
                .filter(isAplha)
                .filter(isVowel)
                .count();
    }

    static long countConsonants(String input) {

        return input.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .filter(isAplha)
                .filter(Predicate.not(isVowel))
                .count();
    }
}
