/**
 * Created by Saurabh on 8/13/2015.
 */
public class LocalExtendsBounds {

    static <T, V extends T> boolean isIn(T x, V[] y) {
        for (V i : y)                //for each loop
            if (x.equals(i))        //autoboxing as equals compares two objects
                return true;

        return false;
    }

    static <T extends Number> double add(T x, T y) {
        return x.doubleValue() + y.doubleValue();
        //+ cannot be applied on T types so x+y is an error
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        if (isIn(2, nums))
            System.out.println(2 + " is in Nums");
        if (!isIn(7, nums))
            System.out.println(7 + " is not in Num");

        String[] st = {"One", "Two", "Three", "Four", "Five"};
        if (isIn("Two", st))
            System.out.println("Two is in st");
        if (!isIn("Seven", st))
            System.out.println("Seven is not is st");

        System.out.println(add(10, 20));
        System.out.println(add(10.5, 10));
        System.out.println(add(10.2f, 18.8f));      //outputs 28.999999046325684 instead of 29

    }
}
