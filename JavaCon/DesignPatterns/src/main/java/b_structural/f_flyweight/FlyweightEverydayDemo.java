package b_structural.f_flyweight;

public class FlyweightEverydayDemo {

	public static void main(String args[]) throws Exception {

		Integer firstInt = 5;

		Integer secondInt = 5;

		//noinspection UnnecessaryBoxing
		Integer thirdInt = Integer.valueOf(10);

		System.out.println(System.identityHashCode(firstInt));
		System.out.println(System.identityHashCode(secondInt));
		System.out.println(System.identityHashCode(thirdInt));

	}
}
