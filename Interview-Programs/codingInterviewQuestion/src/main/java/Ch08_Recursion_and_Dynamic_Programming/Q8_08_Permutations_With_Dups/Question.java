package Ch08_Recursion_and_Dynamic_Programming.Q8_08_Permutations_With_Dups;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {
    private static HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    private static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                printPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }
    }

    private static ArrayList<String> printPerms(String s) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), result);
        return result;
    }

    public static void main(String[] args) {
        String s = "aabbccc";
        ArrayList<String> result = printPerms(s);
        System.out.println("Count: " + result.size());
        for (String r : result) {
            System.out.println(r);
        }
    }

}
