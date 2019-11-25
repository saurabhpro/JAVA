package v2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDictionaryV2Test {

    @Test
    void hash() {
        String key = "abc";
        int actual = MyDictionaryV2.hash(key);

        Assertions.assertEquals(96355, actual);
    }
}