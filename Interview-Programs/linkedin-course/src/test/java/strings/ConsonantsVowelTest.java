package strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConsonantsVowelTest {

    @Test
    void countVowels() {
        String input = "my very educated mother, just show us nine planets";

        int expectedVowels = 16;
        int actual = Math.toIntExact(ConsonantsVowel.countVowels(input));

        Assertions.assertEquals(expectedVowels, actual);
    }

    @Test
    void countConsonants() {
        String input = "my very educated mother, just show us nine planets";

        int expected = 25;
        int actual = Math.toIntExact(ConsonantsVowel.countConsonants(input));

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"there is a quite Mouse"})
    void countVowels_linkedin(String input) {

        int expectedVowels = 10;
        int expectedConst = 8;

        int actual = Math.toIntExact(ConsonantsVowel.countVowels(input));
        Assertions.assertEquals(expectedVowels, actual);

        actual = Math.toIntExact(ConsonantsVowel.countConsonants(input));
        Assertions.assertEquals(expectedConst, actual);
    }

    @ParameterizedTest
    @CsvSource({"there is a quite Mouse,10,8", "HellO,2,3", "I'm happy,3,4"})
    void countVowels_linkedin(String input, int expectedVowels, int expectedConst) {

        int actual = Math.toIntExact(ConsonantsVowel.countVowels(input));
        Assertions.assertEquals(expectedVowels, actual);

        actual = Math.toIntExact(ConsonantsVowel.countConsonants(input));
        Assertions.assertEquals(expectedConst, actual);
    }

}
