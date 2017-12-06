package arrayList;

import java.util.Arrays;

public class Ops {
	public static void main(String[] args) {

		int eArr5[] = new int[]{10, 20};
		System.out.println(Arrays.toString(eArr5));

		java.util.ArrayList<String> seasons = new java.util.ArrayList<>();
		seasons.add(1, "Spring");
		seasons.add(2, "Summer");
		seasons.add(3, "Autumn");
		seasons.add(4, "Winter");
		seasons.remove(2);
		for (String s : seasons)
			System.out.print(s + ", ");
	}
}
