package sybex.ch03;

import java.util.TreeSet;

public class Hello<T> {
	T t;

	public Hello(T t) {
		this.t = t;
	}

	public static void main(String[] args) {
		System.out.print(new Hello<String>("hi"));
		System.out.println(new Hello("there"));

		TreeSet<String> tree = new TreeSet<String>();
		tree.add("one");
		tree.add("One");
		tree.add("ONE");
		System.out.println(tree.ceiling("On"));
	}

	public String toString() {
		return t.toString();
	}


}