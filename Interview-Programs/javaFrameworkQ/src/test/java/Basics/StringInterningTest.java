package Basics;

class StringInterningTest {

    @RepeatedTest(10)
    void testStringConcat() {
        String s3 = "Value1";
        String s2 = "Value2";
        for (int i = 0; i < 100000; ++i) {
            s3 = s3 + s2;       // problem takes 9 secs to execute
        }
    }

    @RepeatedTest(10)
    void testStringBuilderConcat() {
        StringBuilder s3 = new StringBuilder("Value1");
        String s2 = "Value2";
        for (int i = 0; i < 100000; ++i) {
            s3 = s3.append(s2);
        }
    }

    @RepeatedTest(10)
    void testStringBufferConcat() {
        StringBuffer s3 = new StringBuffer("Value1");
        String s2 = "Value2";
        for (int i = 0; i < 100000; ++i) {
            s3 = s3.append(s2);
        }
    }


}