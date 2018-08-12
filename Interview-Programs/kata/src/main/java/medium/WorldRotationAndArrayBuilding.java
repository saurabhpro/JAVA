package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WorldRotationAndArrayBuilding {

    void createPermutationsList(List<String> input) {

    }


    Map<Integer, List<String>> createBatch(List<String> input) {

        Map<Integer, List<String>> n = new HashMap<>();
        List<String> skipList = new ArrayList<>();
        int key = 0;
        for (int i = 0; i < input.size(); i++) {
            List<String> list = new ArrayList<>();
            String or = input.get(i);

            if (!skipList.contains(or)) {
                list.add(or);

                for (int j = i + 1; j < input.size(); j++) {
                    String nxt = input.get(j);

                    if (hasSameCharacters(or.toLowerCase(), nxt.toLowerCase())) {
                        skipList.add(nxt);
                        list.add(nxt);
                    }
                }
                n.put(key, list);
                key++;
            }
        }

        return n;
    }

    private boolean hasSameCharacters(String or, String nxt) {

        boolean rv = false;

        if (or.length() == nxt.length()) {

            final char[] chars = or.toCharArray();
            final char[] chars1 = nxt.toCharArray();
            int i = 0;
            int l = 0;
            do {
                i = chars[l] ^ chars1[l];

                l++;
            } while (l < chars.length);

            if (i == 0) {
                rv = true;
            }
        }


        return rv;
    }
}
