package numberphile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighlyCompositeNumberTest {

    HighlyCompositeNumber hp = new HighlyCompositeNumber();

    @Test
    void isHighlyComposite_12(){
        assertTrue(hp.isHighlyComposite(12));
    }

    @Test
    void isNotHighlyComposite_20(){
        assertTrue(hp.isHighlyComposite(20));
    }

    @Test
    void isNotHighlyComposite_90(){
        assertTrue(hp.isHighlyComposite(90));
    }
}