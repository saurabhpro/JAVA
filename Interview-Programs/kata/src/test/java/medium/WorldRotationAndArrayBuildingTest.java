package medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorldRotationAndArrayBuildingTest {

    private WorldRotationAndArrayBuilding program = new WorldRotationAndArrayBuilding();

    @Test
    void testBaseCase() {
        Map<Integer, List<String>> expected = new HashMap<>();
        expected.put(0, List.of("Tokyo", "Kyoto"));
        expected.put(1, List.of("London", "Donlon"));
        expected.put(2, List.of("Rome"));
        expected.put(3, List.of("Paris"));

        List<String> input = List.of("Tokyo", "Snp", "London", "Rome", "Donlon", "Kyoto", "Paris", "Spn");

        Map<Integer, List<String>> actual = program.createBatch(input);

        assertEquals(expected, actual);
    }
}