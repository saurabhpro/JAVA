package hackerrank;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Proficiency {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.

        boolean rv = false;
        int curr = 0;

        for (int i = 0; i < game.length && i + leap < game.length; i++) {

            if (game[i + 1] == 0)
                i = i + 1;
            else if (game[i + leap] == 0)
                i = i + leap;

        }

        return rv;
    }

    static List<Integer> loopII(int a, int b, int n) {
        List<Integer> tmp = new ArrayList<>(n);
        int sum;

        for (int i = 0; i < n; i++) {
            sum = a;
            for (int j = 0; j <= i; j++) {
                sum += Math.pow(2, j) * b;
            }
            System.out.print(sum + " ");
            tmp.add(sum);
        }

        return tmp;
    }

    static void dataTypeFit() {

        Scanner sc = new Scanner(System.in);
        try {
            long val = sc.nextLong();
            System.out.println(val + " can be fitted in:");
            if (val >= -128 && val <= 127) System.out.println("* byte");
            if (val >= -Math.pow(2, 15) && val <= Math.pow(2, 15) - 1) System.out.println("* short");
            if (val >= -Math.pow(2, 31) && val <= Math.pow(2, 31) - 1) System.out.println("* int");
            if (val >= -Math.pow(2, 63) && val <= Math.pow(2, 63) - 1) System.out.println("* long");

        } catch (InputMismatchException e) {
            System.out.println(sc.next() + " can't be fitted anywhere.");
        }

    }

    public static void main(String[] args) {
        dataTypeFit();
    }
}
