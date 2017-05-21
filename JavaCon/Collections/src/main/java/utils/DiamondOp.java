package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * Created by Saurabh on 1/21/2017.
 * <p>
 * Generics is implemented via Erasure.
 * Type parameters in generics are for compile time safety.
 * Once compiled at bytecode level, raw and generics types are same.
 * Compile erases all the type information at bytecode level.
 * It means bytecode of List<String> is same as bytecode of List.
 */

public class DiamondOp {
	public static void main(String[] args) {
		RightSideDiamondSkipWorks.test();

	}

	static class RightSideDiamondSkipWorks {
		static void test() {
			//String s = new Integer(4); doesnt work - the how come this worked ?
			ArrayList test = new ArrayList<String>();
			test.add(new Integer(1));   //even though the method expects ArrayList of strings

			test.add("Hi");
			RightSideDiamondSkipWorks obj = new RightSideDiamondSkipWorks();
			obj.testMethod1(test);

			ArrayList<String> test2 = new ArrayList();      // only unchecked cast - no real reason unidentified
			test2.add("5");

			ArrayList<Integer> t = (ArrayList) test2;
			t.add(5);

			/*for(Integer i : t){
				System.out.println(i);
			}*/
		}

		//proper type required in args always , cannot use <> here
		void testMethod1(ArrayList<String> argStringArrayList) {
			System.out.println("I am String list");

			// #1
			Arrays.asList(argStringArrayList).stream().forEach(s -> System.out.println(s));
			//or
			Collections.singletonList(argStringArrayList).stream().forEach(System.out::println);

			// #2 also works for array
			Stream.of(argStringArrayList).forEach(System.out::println);

			// #3 Error for arrList
			//Arrays.stream(expectArrayAsNoListTransformDone).forEach(System.out::println);

			// #4 only sout also works for list but not for arrays
			System.out.println(argStringArrayList);
		}

		void testMethod2(ArrayList<Integer> argIntegerArrayList) {
			System.out.println("I am Integer list");
			Stream.of(argIntegerArrayList).forEach(System.out::println);
		}
	}

	class ErasureProblemsWithGenerics {
	/*	void testMethod1(ArrayList<String> argStringArrayList){
			System.out.println("I am String list");
		}

		void testMethod1(ArrayList<Integer> argIntegerArrayList){
			System.out.println("I am Integer list");
		}

		HENCE:-

 * Error:(12, 14) java: name clash: testMethod1(java.util.ArrayList<java.lang.Integer>)
 * and testMethod1(java.util.ArrayList<java.lang.String>) have the same erasure
	*/
	}

}

