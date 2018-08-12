package Introduction.Big_O;

public class Ex_05 {
    private static int f(int n) {
        if (n <= 0) {
            return 1;
        }
        return f(n - 1) + f(n - 1);
    }

    public static void main(String[] args) {
        f(1);
    }
}
