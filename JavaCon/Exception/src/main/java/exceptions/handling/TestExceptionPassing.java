/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package exceptions.handling;

public class TestExceptionPassing {
	public static void main(String[] args) {
		ExceptionPassed.show4();

		//ExceptionPassed.show2();

		try {
			show5();
		}catch (Exception e){
			System.out.println("this is from different class TestExceptionHandling: "+ e);
			e.printStackTrace();
		}
	}

	public static void show5(){
		ExceptionPassed.show2();
	}
}


class ExceptionPassed {
	public static void show1() {
		throw new RuntimeException("show1");
	}

	public static void show2(){
		show1();
	}

	public static void show3(){
		try{
			show1();
		}catch (Exception e){
			System.out.println("show3 captures the excpetion thrown in show1" + e);
		}
	}

	public static void show4(){
		try{
			show2();
		}catch (Exception e){
			System.out.println("show4 captures the already passed excpetion in show2 and show1 -> " + e);
		}
	}
}