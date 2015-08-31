/**
 * Created by Saurabh on 8/31/2015.
 */

class Egg {
    private Yolk y = new Yolk();

    public Egg() {
        System.out.println("new Egg()");
    }

    public void insertYolk(Yolk yk) {
        y = yk;
    }

    public void g() {
        y.f();
    }

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }

        public void f() {
            System.out.println("Egg.Yolk.f()");
        }

    }
}

public class BigEggOverriddenInner extends Egg {

    public BigEggOverriddenInner() {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        Egg e = new BigEggOverriddenInner();
        e.g();
    }

    public class Yolk extends Egg.Yolk {

        public Yolk() {
            System.out.println("BigEggOverriddenInner.Yolk()");
        }

        public void f() {
            System.out.println("BigEggOverriddenInner.Yolk.f()");
        }   //override Egg.Yolk.f();
    }

}
