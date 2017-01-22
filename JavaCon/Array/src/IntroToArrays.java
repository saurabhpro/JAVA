import java.util.Random;

/**
 * Created by Saurabh on 9/1/2015.
 */

public class IntroToArrays {

	//1-D arrays
	private static int ar[];
	private int arr[];

	IntroToArrays() {
		//  System.out.println(ar.length);        throws NullPointerException
	}

	static void _1DArrays() {
		/**
		 * arrays are 0 index based so a[-7] will generate AIOUBE (ArrayIndexOutOfBoundsException) on Runtime
		 */
		int[] a = new int[3];
		// System.out.println(  a[-7]);        //its not Runtime Exception, not compile time so no red lines

	}

	static void _2DArrays() {

		//Array of Arrays [2-D]
		int[][] a = new int[4][3];     //perfectly legal
		int[][] b = new int[4][];      //recommended if our needs are not fixed
		/**
		 * 2D arrays of type int is basically
		 * array of type int array (int[]), with each element in that array holding reference to another int array,
		 * the second dimension holds the actual int primitives
		 *
		 * JVM needs to know only the size of the object assigned to variable b.
		 */

		System.out.println(a.length);       //returns the no of objects [i.e. 4] each of which contain ref to 6 sized array
		System.out.println(a[0].length);    //should give 3 now

		/**
		 *    array.length is a property of array class , not a method , which contain the number of elements in array!
		 *    ref. kathy sierra
		 */

		System.out.println("\nfixed sized array -  new int[4][3];");
		for (int[] a1 : a) {
			for (int a2 : a1)
				System.out.print(a2 + " ");
			System.out.println();
		}


		System.out.println("\ndynamically allocated array -  new int[4][];");
		for (int[] b1 : b) {
			b1 = new int[new Random().nextInt(5)];

			for (int b2 : b1)
				System.out.print(b2 + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		//IntroToArrays ir = new IntroToArrays();
		_1DArrays();
		_2DArrays();

		/**
		 * ANONYMOUS ARRAY CREATION
		 */
		System.out.println("ANONYMOUS ARRAY in Enhanced for loop");
		for (int i : new int[]{5, 4, 9, 10, 20})
			System.out.print(i + " ");


	}
}

/*OUTPUT
4
3

fixed sized array -  new int[4][3];
0 0 0
0 0 0
0 0 0
0 0 0

dynamically allocated array -  new int[4][];
0 0
0 0 0 0
0
0
ANONYMOUS ARRAY in Enhanced for loop
5 4 9 10 20
 */