package collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MostRepeatedWords {


    static String findMostRepeatedWord(String s) {
        Map<String, Integer> result = new HashMap<>();

        // Normalize input
        String[] split = s.toLowerCase().split("[ \\t\\n\\r.;:!?()]");
        // See what the words are
        // System.out.println(Arrays.toString(split));

        for (String value : split) {
            if (!value.isBlank() && !isCommonWord(value)) {
                if (!result.containsKey(value)) {
                    result.put(value, 1);
                } else {
                    result.put(value, result.get(value) + 1);
                }
            }
        }

        Map.Entry<String, Integer> max = result.entrySet()
                .stream()
                .max(Map.Entry.<String, Integer>comparingByValue())
                .get();

        System.out.println("Most repeated word: " + max.getKey() + "\nRepeated: " + max.getValue() + " times");

        return max.getKey();
    }

    private static boolean isCommonWord(String value) {
        final List<String> commonWords = List.of("the", "a", "or", "an", "it", "and", "but", "is", "are",
                "of", "on", "to", "was", "were", "in", "that", "i",
                "your", "his", "their", "her", "you", "me", "all");

        return commonWords.contains(value);
    }
}
