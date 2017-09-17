package com.saurabh;

//simple Java method main (method main does not call any other methods)

import java.util.Scanner;

public class Java_Method_main //change class name to the class you are creating 
{
	//global variables (fields in OOP)
	private Scanner input;

	public static void main(String args[]) //required method main for an executable class
	{
		System.out.println("Hello");
		Java_Method_main program = new Java_Method_main();
		program.main();
	}

	public void main() //non-static method main that can call non-static methods
	{
		//create a Scanner object for console input
		input = new Scanner(System.in);  //create Scanner input object

		//enter your method main statements here
	}

	//enter additional methods here

}