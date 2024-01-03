package map;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static map.MapMerge.Operation.operation;

/**
 * This function is free to:
 * <p>
 * overwrite old value by simply returning the new one: (old, new) -> new
 * keep the old value by simply returning the old one: (old, new) -> old
 * somehow merge the two, e.g.: (old, new) -> old + new
 * or even remove old value: (old, new) -> null
 */
public class MapMerge {

    public static void main(String[] args) {
        countWordOccurrences();
        countAccountCash();
    }

    private static void countWordOccurrences() {

        final var words = List.of("Foo", "Bar", "Foo", "Buzz", "Foo", "Buzz", "Fizz", "Fizz");

        final var map = new HashMap<String, Integer>();
        words.forEach(word -> {
            final var prev = map.get(word);
            if (prev == null) {
                map.put(word, 1);
            } else {
                map.put(word, prev + 1);
            }
        });

        // the above is similar to this ->

        words.forEach(word -> {
            map.putIfAbsent(word, 0);   // initialize all words with 0
            map.put(word, map.get(word) + 1); // get the existing word count and put +1
        });

        // but the map.get() can be removed with a cleaner
        words.forEach(word -> {
            map.putIfAbsent(word, 0);
            map.computeIfPresent(word, (w, prev) -> prev + 1);
        });
        // or compute as putIfAbsent and computeIfPresent can be "merged"
        words.forEach(word ->
            map.compute(word, (w, prev) -> prev != null ? prev + 1 : 1)
        );

        // HENCE we reach here ->
        words.forEach(word ->
                map.merge(word, 1, (prev, curr) -> prev + curr)
            // for this example BiFunction is useless it is required by merge
        );
    }

    // if you wonder why you have not seen merge a lot -> the reason is collect does this better and more functionally
    public static Map<String, Integer> countWordOccurrencesWithCollect(List<String> words) {
        return words.stream()
            .collect(
                toMap(
                    identity(),     // the word
                    __ -> 1,      // init value for counter
                    Integer::sum,   // biFn on counter value
                    HashMap::new    // resulting map
                )
            );
    }

    record Operation(String accountNumber, BigDecimal amount) {

        public static Operation operation(String accountNumber, BigDecimal amount) {
            return new Operation(accountNumber, amount);
        }

    }

    private static void countAccountCash() {

        final var operations = List.of(
            operation("123", new BigDecimal("10")),
            operation("456", new BigDecimal("1200")),
            operation("123", new BigDecimal("-4")),
            operation("123", new BigDecimal("8")),
            operation("456", new BigDecimal("800")),
            operation("456", new BigDecimal("-1500")),
            operation("123", new BigDecimal("2")),
            operation("123", new BigDecimal("-6.5")),
            operation("456", new BigDecimal("-600"))
        );

        // We would like to compute balance (total over operations’ amounts) for each account.
        final var balances = new HashMap<String, BigDecimal>();

        // so instead of this
//        operations.forEach(op -> {
//            final var key = op.accountNumber();
//            balances.putIfAbsent(key, ZERO);
//            balances.computeIfPresent(key, (accNo, prev) -> prev.add(op.amount()));
//        });

        operations.forEach(op ->
            balances.merge(
                op.accountNumber(),
                op.amount(),
                BigDecimal::add // a biFn takes 2 arguments and returns 1 result
            )
        );

        // Single line and thread-safe. ConcurrentHashMap is obviously thread-safe, but not across many operations, e.g. get() and then put().
        // However merge() makes sure no updates are lost as it’s properly implemented in ConcurrentHashMap. This means we can atomically perform insert-or-update operation.

    }

}