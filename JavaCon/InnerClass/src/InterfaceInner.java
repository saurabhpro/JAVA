/**
 * Created by Saurabh on 9/2/2015.
 */
interface Inn {
    static void show() {
        System.out.println("show");
    }

    class InterfaceInner {
        public static void main(String[] args) {
            System.out.println("Hello");
            InterfaceInner in = new InterfaceInner();
            show();
        }
    }
}

