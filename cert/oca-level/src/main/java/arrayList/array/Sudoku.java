package arrayList.array;

import java.util.Arrays;

public class Sudoku {
	private static int[][] game = new int[6][6];

	public static void main(String[] args) {
		game[3][3] = 6;
		Object[] obj = game;
		System.out.println(Arrays.deepToString(obj));
		//obj[3] = "X";       // ArrayStoreException
		System.out.println(game[3][3]);

		System.out.println(args);
		System.out.println(Arrays.toString(args));
		//System.out.println(args[0]); // ArrayIndexOutOfBoundsException
		String s = null;
		System.out.println(s);

		System.out.println(!true);

		//String s = 9;
	}
}
