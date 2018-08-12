import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://examples.javacodegeeks.com/enterprise-java/testng/testng-beforemethod-example/
 * Created by saurabhkumar on 26/07/17.
 */
public class NextGreaterElementTest {


    private NextGreaterElement nextGreaterElement;

    @BeforeEach
    public void initClass() {
        nextGreaterElement = new NextGreaterElement();

    }

    /**
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    @Test
    public void findNextMaximumTest2() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Method method = NextGreaterElement.class.getDeclaredMethod("findNextMaximum", int[].class, int.class); //NoSuchMethodException

        method.setAccessible(true); //magic line

        int output = (int) method.invoke(nextGreaterElement, new int[]{1, 3, 2, 4}, 1);   //InvocationTargetException, IllegalAccessException

        assertEquals(output, 4);
    }

    @Test
    public void findNextMaximumTest1() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Method method = NextGreaterElement.class.getDeclaredMethod("findNextMaximum", int[].class, int.class); //NoSuchMethodException

        method.setAccessible(true); //magic line

        int output = (int) method.invoke(nextGreaterElement, new int[]{1, 3, 2, 4}, 0);   //InvocationTargetException, IllegalAccessException

        assertEquals(output, 3);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testGetNextLargestArray() throws Exception {
        int[] res = NextGreaterElement.getNextLargestArray(new int[]{1, 3, 2, 4});
        int[] expectRes = new int[]{3, 4, 4, -1};

        for (int i = 0; i < res.length; i++) {
            assertEquals(res[i], expectRes[i]);

        }
    }

    @Test
    public void testPrintNGE() throws Exception {

        int arr[] = {11, 13, 21, 3};
        int n = arr.length;
        NextGreaterElement.printNGE(arr, n);
    }

}