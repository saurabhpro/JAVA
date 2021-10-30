package cvent.nullLast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsLast;

public class ComparatorNullLast {
    public static final String BLADE_LOCALE_FILE_PATH = "/Users/saurabh.kumar/GitHub/JAVA/Playground/src/main" +
            "/resources/translations/bladesLocales.json";
    public static final String LOCALES = "locales";
    public static final String BLADE_ID = "bladeId";

    public static void main(String[] args) throws IOException {
        final List<BladeLocale> bladeLocales = getBladeLocales(1001L, new ObjectMapper());
        System.out.println(bladeLocales);
    }

    public static List<BladeLocale> getBladeLocales(Long bladeId, ObjectMapper mapper) throws IOException {
        final byte[] resourceFile = Files.readAllBytes(Path.of(BLADE_LOCALE_FILE_PATH));

        final JsonNode jsonNode = mapper.readValue(resourceFile, JsonNode.class);

        Iterator<JsonNode> bladesIterator = jsonNode.elements();
        while (bladesIterator.hasNext()) {
            JsonNode bladeNode = bladesIterator.next();
            if (bladeId.equals(bladeNode.get(BLADE_ID).longValue())) {
                if (bladeNode.get(LOCALES) == null) {
                    throw new RuntimeException("locales cannot be null for a blade");
                }

                final List<BladeLocale> locales = mapper.convertValue(bladeNode.get(LOCALES),
                        new TypeReference<>() {
                        });

//                locales.sort((locale1, locale2) -> {
//                    if (locale1.getSortOrder() == null) {
//                        return locale2.getSortOrder() == null ? 0 : 1;
//                    }
//                    if (locale2.getSortOrder() == null) {
//                        return -1;
//                    }
//                    return locale1.getSortOrder().compareTo(locale2.getSortOrder());
//                });

                locales.sort(comparing(BladeLocale::getSortOrder, nullsLast(Comparator.naturalOrder())));
                return locales;
            }
        }
        return Collections.emptyList();
    }
}
