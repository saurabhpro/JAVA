package com.saurabh.codes;

public class CodeSnippetsJDK18 {

    /**
     * The following code shows how to use {@code Optional.isPresent}:
     * {@snippet :
     * if (v.isPresent()) {
     *     System.out.println("v: " + v.get());
     * }
     *}
     * <p>
     * NOTE: it is important to have { @snippet
     * only then the code formatting works if identified by ides
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /**
     * The following code shows how to use {@code Optional.isPresent}:
     * {@snippet file = "ShowOptional.java" region = "example"}
     * <p>
     * The attributes in the {@snippet...} tag identify the file and the name of the region of the file to be displayed.
     * The @start and @end tags in ShowOptional.java define the bounds of the region.
     * In this case, the content of the region is the same as the content in the previous example.
     */
    void test() {

    }

    /**
     * A simple program.
     * {@snippet :
     * class HelloWorld {
     *     public static void main(String... args) {
     *         System.out.println("Hello World!");      // @highlight substring="println"
     *     }
     * }
     *}
     */
    void test2() {

    }
}