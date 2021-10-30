package saurabh.j14;

/**
 * Java 11 added the Descriptive NPE to array access NPE's
 * but Java 14 added the method and other type of descriptions
 */
 //-XX:+ShowCodeDetailsInExceptionMessages
public class NPEGoodDescription {

    private static int np(){
        String x = null;
        return x.hashCode();
    }

    public static void main(String[] args) {
        // np();
        /*
        >= Java 14
        Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.hashCode()" because "x" is null
	        at saurabh.j14.NPEGoodDescription.np(NPEGoodDescription.java:8)
	        at saurabh.j14.NPEGoodDescription.main(NPEGoodDescription.java:11)

	     < Java 14
	     Exception in thread "main" java.lang.NullPointerException
	        at saurabh.j14.NPEGoodDescription.np(MyClass.java:14)
	        at saurabh.j14.NPEGoodDescription.main(MyClass.java:9)
         */

        int[] a = new int[2];
        int res = a[3];
        /*
         >= Java 11
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 2
	        at saurabh.j14.NPEGoodDescription.main(NPEGoodDescription.java:19)

	     < Java 11
	    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
	        at MyClass.main(MyClass.java:10)
         */
        System.out.println(res);
    }
}
