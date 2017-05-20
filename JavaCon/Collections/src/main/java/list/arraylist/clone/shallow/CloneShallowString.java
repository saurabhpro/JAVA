package list.arraylist.clone.shallow;

import java.util.ArrayList;

/**
 * Created by Saurabh on 9/6/2015.
 */

public class CloneShallowString {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		//adding elements to end
		al.add("First");
		al.add("Second");
		al.add("Third");
		al.add("Random");

		System.out.println("Actual ArrayList " + al);

		ArrayList<String> copy = (ArrayList<String>) al.clone();
		System.out.println("Cloned ArrayList " + copy);

		//if (al.get(0) == copy.get(0)) comparing two strings using == instead of equals()
		if (al.get(0).equals(copy.get(0)))       //compares references not strings
			System.out.println("Shallow");
		if (al != copy)
			System.out.println("Clone Made");
	}
}
