/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.arraylist.model;

/**
 * Created by Saurabh on 9/6/2015.
 */
public class Emp {
	public final int id;
	public final String name;

	public Emp(int x, String st) {
		id = x;
		name = st;
	}


	@Override
	public boolean equals(Object ob) {
		System.out.println("Inside Overridden Equals");
		Emp e1 = (Emp) ob;
	   /*
	    if(this.id==e1.id) return true;
        else            return false;
        SIMPLIFIED INTO BELOW CODE */

		return this.id == e1.id && this.name.equals(e1.name);
	}
}

