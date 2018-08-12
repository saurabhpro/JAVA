package Introduction.Big_O;

@SuppressWarnings("Duplicates")
public class Ex_20 {
    private static int powersOf2(int n) {
        if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powersOf2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }

    public static void main(String[] args) {
        powersOf2(100);
    }
}
