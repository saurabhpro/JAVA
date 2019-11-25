import java.util.Arrays;

public class MyDictionaryV1 {
    private static final int DEFAULT_MAP_SIZE = 10;
    private int arr[];

    MyDictionaryV1() {
        this(DEFAULT_MAP_SIZE);
    }

    MyDictionaryV1(int defaultMapSize) {
        arr = new int[defaultMapSize];
    }

    public void put(int key, int value) {
        arr[key] = value;

        System.out.println(Arrays.toString(arr));
    }

    public int get(int key) {
        return arr[key];
    }
}
