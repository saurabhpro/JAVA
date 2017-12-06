package arrayList.same_name;

import java.util.List;

abstract interface Roll {
	// ye bhi hoskta hai abstract

	int M1 = 45;
}

public class ArrayList implements Roll {
	// int M1 = Roll.M1;   // static variables should be accessed with class reference
	public static void main(String[] args) {
		List i = new java.util.ArrayList();

		System.out.println(M1); // if no local M1 - M1 would refer to interface one
	}
}

