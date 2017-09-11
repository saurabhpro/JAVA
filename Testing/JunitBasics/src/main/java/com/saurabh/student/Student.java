package com.saurabh.student;

/**
 * Created by Saurabh on 11/29/2015.
 */


public class Student {


	public static int result(int a, int b, int c, int d, int e) {
		int avg;
		int result;

		avg = (a + b + c + d + e) / 5;
		if (avg >= 75)
			result = 1;
		else if (65 <= avg && avg < 75)
			result = 2;
		else if (55 <= avg && avg < 65)
			result = 3;
		else
			result = 4;

		return result;

	}
}
