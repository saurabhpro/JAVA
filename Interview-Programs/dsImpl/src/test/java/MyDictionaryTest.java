import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MyDictionaryTest {

    @Test
    void testMapPut() {

        MyDictionaryV1 dict = new MyDictionaryV1();
        dict.put(5, 8);
    }

    @Test
    void testMapGet() {

        MyDictionaryV1 dict = new MyDictionaryV1();
        dict.put(5, 8);
        int actual = dict.get(5);

        Assertions.assertEquals(8, actual);

        HashMap h;
    }

}