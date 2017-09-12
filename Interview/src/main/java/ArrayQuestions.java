import java.util.Random;

/**
 * Created by Saurabh on 9/3/2015.
 */
public class ArrayQuestions {
    static int counter;

    public static void main(String[] args) {
        occurOnce(new int[]{2, 4, 2, 3, 3, 4, 1, 5, 1});

        counter = 0;
        print(5);

        swap(15, 18);

        counter = 0;

        int[] arr = new int[18];
        for (int i = 0; i < arr.length; i++)
            arr[i] = new Random().nextInt(20);

        print2SmallestWithoutTournament(arr, arr.length);
    }


    static void print(int n) {
        if (n > 0) {
            System.out.print("Hello " + ++counter);
            print(n - 1);
        }
        System.out.print("World " + ++counter);
        /*
        prints n time Hello
        and n+1 time world since since when n ==0, it will not go inside if block and will print world and return.
         */
    }

    static void print2SmallestWithoutTournament(int arr[], int arr_size) {
        int i, first, second;

        for (int t : arr)
            System.out.print(t + " ");
    /* There should be atleast two elements */
        if (arr_size < 2) {
            System.out.println(" Invalid Input ");
            return;
        }

        first = second = Integer.MAX_VALUE;
        for (i = 0; i < arr_size; i++) {


              /* If current element is smaller than first then update both first and second */
            if (arr[i] < first) {
                second = first;
                first = arr[i];
            }

		/* If arr[i] is smaller than second but not smaller than first then update second */
            else if (arr[i] < second && arr[i] != first)
                second = arr[i];

            ++counter;

        }
        if (second == Integer.MAX_VALUE)
            System.out.println("There is no second smallest element\n" + counter);
        else
            System.out.println("The smallest element is " + first + " and second Smallest element is " + second + " Counter " + counter);
    }

    private static void swap(int a, int b) {
        a = a ^ b;
        /**
         *  5 = 0101
         *  8 = 1000
         *  a = 1101    = 8+4+1 = 13
         */
        System.out.print("\n" + a + " ");
        b = a ^ b;

        /**
         * 13 = 1101
         * 8 = 1000
         * b = 0101
         */
        System.out.print(b + " ");
        a = a ^ b;
        /**
         * 13 = 1101
         * 5 = 0101
         * a = 1000
         */
        System.out.print(a + " ");

        System.out.print(" swapped value" + a + " " + b + "\n");
    }

    private static void occurOnce(int[] ints) {

        int temp = ints[0];
        for (int i = 1; i < ints.length; i++) {
            temp = temp ^ ints[i];
        }

        for (int i : ints)
            System.out.print(i + " ");
        System.out.println(" occuring only once: " + temp);


    }
}
