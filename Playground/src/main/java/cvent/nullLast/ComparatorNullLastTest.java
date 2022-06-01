package cvent.nullLast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorNullLastTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getBladeLocales() throws IOException {
        List<BladeLocale> actualBladeLocale = ComparatorNullLast.getBladeLocales(1001L, objectMapper);
        //List<BladeLocale> expectedBladeLocale = List.of(DataFixtures.getInstance().getBladeLocales());
        assertNotNull(actualBladeLocale);
        assertEquals(actualBladeLocale.size(), 10);
        assertEquals("Deutsch", actualBladeLocale.get(0).getLocaleName());
    }

}