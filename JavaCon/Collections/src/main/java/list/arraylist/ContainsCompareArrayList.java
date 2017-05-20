package list.arraylist;

import list.arraylist.model.Emp4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 9/13/2015.
 */

public class ContainsCompareArrayList {

	static void compareStringArrayListUsingContains() {
		ArrayList<String> ar = new ArrayList<>();
		ar.add("How are you");
		ar.add("Good Morning");
		ar.add("Bye");
		ar.add("Good Night");

		ArrayList<String> ar2 = new ArrayList<>();
		ar2.add("Howdy");
		ar2.add("Good Evening");
		ar2.add("Bye");
		ar2.add("Good Night");

		System.out.println("\n\nList One : " + ar);
		System.out.println("List Two : " + ar2);

		//Storing the comparison output in ArrayList<String>
		ArrayList<String> ar3 = new ArrayList<>();
		for (String str : ar)
			ar3.add(ar2.contains(str) ? "Yes" : "No");
		System.out.println(ar3);

		//storing the comparison output in ArrayList<String>
		ArrayList<String> ar4 = new ArrayList<>();
		for (String str : ar)
			ar4.add(String.valueOf(ar2.contains(str) ? 1 : 0));     //without String.valueOf we cannot add 1 , 0 as they are integers
		System.out.println(ar4);
	}

	static void compareArrayListOwnClassUsingContains() {
		ArrayList<Emp4> list = new ArrayList<>();
		Emp4 e2 = new Emp4(1001);

		//  list.add(new main.java.list.arraylist.model.Emp4(1001));
		list.add(new Emp4(1002));
		list.add(new Emp4(1003));
		list.add(new Emp4(1004));
		list.add(new Emp4(1005));

		list.add(new Emp4(1001));       //equals run 5 times now
		//these arguments are called anonymous objects

		System.out.print("Actual List - ");
		for (Emp4 e : list)
			System.out.print(e.id + " ");

		System.out.println();
		System.out.println("ArrayList contains the id 1001 : " + list.contains(e2));
		/*
		By default contains calls equals method, now since it is own own class compiler
        doesn't know what to search for and we have not overridden equals in main.java.list.arraylist.model.Emp3
        So, contains will run the equals of Object class that compares Reference Id's = False

        in main.java.list.arraylist.model.Emp4 we have overridden equals so now contains compares int id's not references
         */
	}

	static void containsAllMyList() {
		ArrayList<String> ar = new ArrayList<>();
		ar.add("First");
		ar.add("Second");
		ar.add("Third");
		ar.add("Random");
		ar.add("Click");

		List<String> list = new ArrayList<>();
		list.add("Second");
		list.add("Random");

		System.out.println("ArrayList - " + ar + "\nList - " + list);
		System.out.println("Does ArrayList Contains All elements of List?: " + ar.containsAll(list));

		list.add("One");
		System.out.println("\nArrayList - " + ar + "\nList - " + list);
		System.out.println("Does ArrayList Contains All elements of List after adding One?: " + ar.containsAll(list));


	}

	public static void main(String[] args) {

		System.out.println("Function to check if some element of one list is present in another List!");
		compareArrayListOwnClassUsingContains();
		compareStringArrayListUsingContains();

		System.out.println("\nFunction to check if all elements of list2 is present in list1!");
		containsAllMyList();
	}
}
