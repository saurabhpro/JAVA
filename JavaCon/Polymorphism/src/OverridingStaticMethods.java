/**
 * Created by Saurabh on 9/1/2015.
 */

class StaticOverriding {
    static void show() {
        System.out.println("Inside Parent Static Method");
    }
}

class ChildStaticOverride extends StaticOverriding {
    //  void show() //instance method show() in ChildStaticOverride cannot override static method show() in StaticOverriding
            /* Error:(11, 10) java: show() in ChildStaticOverride cannot override show() in StaticOverriding
                   overridden method is static */
    //we can only re-define it using static modifier
    static void show() {
        System.out.println("Inside Overriden Child");
    }
}

public class OverridingStaticMethods {
    public static void main(String[] args) {
        StaticOverriding sOb = new ChildStaticOverride();
        StaticOverriding.show(); //static show of father
    }

}
