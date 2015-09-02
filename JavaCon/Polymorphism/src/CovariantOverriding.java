/**
 * Created by Saurabh on 9/2/2015.
 */

class Base {
}

class Child extends Base {
}

class NewBase {
    Base Show() {
        System.out.println("Inside NewBase");
        return new Child();     //upcasting on the fly
    }

    Number disp() {
        return null;
    }
}

class NewChild extends NewBase {
    @Override
    Child Show() {
        System.out.println("Inside NewChild, Indeed Covarient types are allowed at return types");
        return new Child();
    }

    @Override
    Integer disp() {
        return null;
    }
}

public class CovariantOverriding {
    public static void main(String[] args) {
        NewBase newBase = new NewBase();

        Base base = newBase.Show();
    }

}

