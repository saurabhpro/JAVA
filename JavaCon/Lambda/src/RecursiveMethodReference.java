import java.util.function.LongFunction;

/**
 * Created by Saurabh on 2/27/2016.
 * <p>
 * Lambda functions can't be recursive
 */
public class RecursiveMethodReference {
    public static void main(String[] args) {
        LongFunction<Long> p = RecursiveMethodReference::factorial;    //IntFunction only cares about return type

        long val = 9;
        long result = p.apply(val);     //IntFunction cant be applied to long, so used LongFunction
        System.out.println("Factorial of " + val + " = " + result);

    }

    public static long factorial(long num) {
        if (num == 0 || num == 1)
            return 1;
        else
            return num * factorial(num - 1);
    }
}
