import static java.lang.System.out;

public class BreakClass {

    // DOG
    // CAT
    public static void main(String[] args) {
        loop:
        do {
            out.println("DOG");
            break loop;
        } while (true);
        out.println("CAT");

        loop:
        while (true) {
            out.println("DOG");
            break loop;
        }
        out.println("CAT");

        loop:
        for (; ; ) {
            out.println("DOG");
            break loop;
        }
        out.println("CAT");
    }
}
