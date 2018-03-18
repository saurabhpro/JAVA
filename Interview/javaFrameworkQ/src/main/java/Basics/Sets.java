package Basics;

import java.util.TreeSet;

public class Sets {
	public static void main(String[] args) {

		TreeSet<Integer> numbersTreeSet = new TreeSet<>();
		numbersTreeSet.add(55);
		numbersTreeSet.add(25);
		numbersTreeSet.add(35);
		numbersTreeSet.add(5);
		numbersTreeSet.add(45);

		//Find the highest number which is lower than 25
		System.out.println(numbersTreeSet.lower(25));//5

		//Find the highest number which is lower than or equal to 25
		System.out.println(numbersTreeSet.floor(25));//25

		//Find the lowest number higher than 25
		System.out.println(numbersTreeSet.higher(25));//35
	}
}
