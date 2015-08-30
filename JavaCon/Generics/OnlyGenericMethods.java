/**
 * Created by Saurabh on 8/13/2015.
 */
public class OnlyGenericMethods {

    static <T> void showVal1(T x) {
        System.out.println(x);
    }

    static <T extends Number> void showVal2(T x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        OnlyGenericMethods gm = new OnlyGenericMethods();

        gm.showType("");
        gm.showType(76);    //autoboxing Automatic Type Inference
        OnlyGenericMethods.showVal2(96.8f);     //static method
        showVal1("Hello");
        /*
        showVal2("Hello");

        Error:(21, 9) java: method showVal2 in class OnlyGenericMethods cannot be applied to given types;
          required: T
          found: java.lang.String
          reason: inferred type does not conform to upper bound(s)
            inferred: java.lang.String
            upper bound(s): java.lang.Number
         */
    }


    public <T> void showType(T x) {
        System.out.println(x.getClass().getName());
    }
}
