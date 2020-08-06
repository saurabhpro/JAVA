package sk.mockorspy;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SpyHowTo {

//    @Spy
//    private final List<String> spyList = new ArrayList<>();

    @Test
    public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
        List<String> list = new ArrayList<>();
        List<String> spyList = Mockito.spy(list);

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());
    }

    @Test
    public void whenStubASpy_thenStubbed() {
        List<String> list = new ArrayList<>();
        List<String> spyList = Mockito.spy(list);

        assertEquals(0, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }
}
