import java.util.Arrays;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Sum s1 = new Sum();
        // s1.SumOfTwoSides();
    //    s1.sumToArrayBetter();
    }

    void SumOfTwoSides() {
        int[] ar = Arrays.stream(new Scanner(System.in).nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int suml, sumr;
        for (int i = 1; i < ar.length - 1; i++) {
            suml = sumr = 0;

            for (int k = i - 1; k >= 0; k--)
                suml += ar[k];

            sumr = ar[i];

            for (int j = i + 1; j < ar.length; j++)
                if (suml < sumr) break;
                else sumr += ar[j];


            if (suml == sumr) {
                System.out.println("Split at " + (i) + " Sum Value = " + suml);
                break;
            }

        }
    }

    void sumToArrayBetter() {
        int[] ar = Arrays.stream(new Scanner(System.in).nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int suml = 0, sumr = 0;

        int pivot = 0;
        for (int i = 0, j = ar.length - 1; i < j; ) {
            System.out.println(i + ":" + suml + " " + j + ":" + sumr);
            if (suml > sumr) sumr += ar[j--];
            else suml += ar[i++];

            //  System.out.println(i+":"+suml +" "+j+":"+sumr+"\n");
            pivot = i;
        }

        if (suml == sumr)
            System.out.println(pivot);

    }

}
