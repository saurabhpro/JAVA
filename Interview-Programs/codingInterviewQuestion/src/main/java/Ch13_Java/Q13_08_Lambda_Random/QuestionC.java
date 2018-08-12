package Ch13_Java.Q13_08_Lambda_Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")

/*
 * Using Lambda expressions, write a function List<Integer> getRandomSubset( List<Integer> list)
 * that returns a random subset of arbitrary size. All subsets (including the empty set) should be
 * equally likely to be chosen.
 *
 * It's tempting to approach this problem by picking a subset size from 0 to N
 * and then generating a random subset of that size.
 *
 * That creates two issues:
 * 1. We'd have to weight those probabilities. If N > 1, there are more subsets of size N/2 than
 *      there are of subsets of size N (of which there is always only one).
 * 2. It's actually more dif cult to generate a subset of a restricted size (e.g., specifically 1O)
 *      than it is to generate a subset of any size.
 */
public class QuestionC {
    private static final Random random = new Random();
    private static final Predicate<Object> flipCoin = o -> random.nextBoolean();


    private static List<Integer> getRandomSubset(List<Integer> list) {
        //noinspection UnnecessaryLocalVariable
        List<Integer> subset =
                list.stream()
                        .filter(flipCoin).
                        collect(Collectors.toList());
        return subset;
    }

    public static void main(String... args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        List<Integer> subset = getRandomSubset(list);
        System.out.println(subset.toString());
    }

}