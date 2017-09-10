package creational.builder;

import model.Knight;

/**
 * @author saurabh
 */
public class Main {

	public static void main(String[] args) {
		KnightBuilder knightBuilder = new KnightBuilder();

		knightBuilder.createFightingHolyKnight();
		Knight knight = knightBuilder.getKnight();  //get knight

		System.out.println(knight.getName());


		//reuse the builder to get more knights
		knightBuilder.createFightingMajesticKnight();
		knight = knightBuilder.getKnight();

		System.out.println(knight.getName());
	}
}
