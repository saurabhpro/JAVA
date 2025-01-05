package map;

import java.util.HashMap;

public class MapWithChangedKey {

    public static void main(String[] args) {
        sb();
        string2();
    }

    private static void sb() {
        final var map = new HashMap<StringBuilder, String>();
        final var key1 = new StringBuilder("key1");
        final var key2 = new StringBuilder("key2");

        map.put(key1, "value1");
        map.put(key2, "value2");

        key1.append("__changed");

        System.out.println("sb value for key1: " + map.get(key1));
        System.out.println("sb value for key1: " + map.get(new StringBuilder("key1__changed")));
        System.out.println("sb value for key2: " + map.get(new StringBuilder("key2")));
    }

    private static void string2() {
        final var map = new HashMap<String, String>();
        var key1 = "key1";
        final var key2 = "key2";

        map.put(key1, "value1");
        map.put(key2, "value2");

        key1 += "__changed";

        System.out.println("sb value for key1: " + map.get(key1));
        System.out.println("sb value for key1: " + map.get("key1__changed"));
        System.out.println("sb value for key2: " + map.get("key2"));
    }
}
