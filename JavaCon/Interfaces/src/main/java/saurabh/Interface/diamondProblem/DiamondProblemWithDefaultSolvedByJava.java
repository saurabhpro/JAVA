/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Interface.diamondProblem;

interface FirstFile1 {
	default void checkThis() {
		System.out.println("Im in Parent 1");
	}
}

interface SecondFile2 {
	default void checkThis() {
		System.out.println("Im in Parent 2");
	}
}

public class DiamondProblemWithDefaultSolvedByJava implements SecondFile2, FirstFile1 {

	public static void main(String[] args) {
		DiamondProblemWithDefaultSolvedByJava tester = new DiamondProblemWithDefaultSolvedByJava();
		tester.checkThis();
	}

	/**
	 * Java 8 addresses this by requiring you to provide an implementation for the ambiguous method
	 * in the relevant class, in this case DiamondProblemWithDefaultSolvedByJava.
	 */
	@Override
	public void checkThis() {
		SecondFile2.super.checkThis();
	}
}