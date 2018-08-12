package hackerrank;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProficiencyTest {

    @Test
    void canWin() {
    }

    @Test
    void loopII() {
        int a = 0;
        int b = 2;
        int n = 10;
        // (a + 2^0.b), (a + 2^0.b + 2^1.b),....
        List<Integer> expected = List.of(2, 6, 14, 30, 62, 126, 254, 510, 1022, 2046);

        List<Integer> actual = Proficiency.loopII(a, b, n);

        assertEquals(expected, actual);
    }

    @Test
    void loopII2() {
        int a = 5;
        int b = 3;
        int n = 5;
        // (a + 2^0.b), (a + 2^0.b + 2^1.b),....
        List<Integer> expected = List.of(8, 14, 26, 50, 98);

        List<Integer> actual = Proficiency.loopII(a, b, n);

        assertEquals(expected, actual);
    }

    @Test
    void dataTypeFit() {
        Proficiency.dataTypeFit();
    }
}