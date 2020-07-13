/*
 * Copyright (c) 2020 Saurabh Kumar
 */

package methodReference;

import java.util.function.Consumer;

public class MethodReferenceVsLambda {

    /**
     * I'm a little bit confused about Java lambdas and method references behaviour. For ex., we have this code:
     * Output:
     * <p>
     * 23
     * This works as expected, but if we replace
     * <p>
     * s -> sBuilder.append(s)
     * <p>
     * with
     * <p>
     * sBuilder::append
     * <p>
     * the output will be:
     * <p>
     * 2
     * <br/>
     * <p>
     * * In the lambda expression, the sBuilder field is captured, but not evaluated.
     * It will only be evaluated when the corresponding function interface method is invoked.
     * At that point, the sBuilder references the new instance created and assigned to the field with
     * *
     * * sBuilder = new StringBuilder("2");
     * * In the method reference, the sBuilder field is evaluated immediately to produce a Consumer instance. That value references the instance created in the static initializer
     * *
     * * private static StringBuilder sBuilder = new StringBuilder("1");
     * * and the Consumer will operate on that one. You print the new one.
     */
    private static StringBuilder sBuilder = new StringBuilder("1");

    public static void main(String[] args) {
        Consumer<String> consumer = s -> sBuilder.append(s);
        sBuilder = new StringBuilder("2");
        consumer.accept("3");
        System.out.println(sBuilder);
    }

}