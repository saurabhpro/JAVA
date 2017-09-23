/**
 * Created by Saurabh on 8/14/2015.
 */


class Dad {

	static class IHereToo {
		static void getThis() {
			System.out.println("Im calling form insider the static class of Dad");
		}
	}
}

public class StaticClass extends Dad {

	public static void main(String[] args) {

		Dad.IHereToo.getThis();      //prints the message from dad

		StaticClass.IHereToo.getThis();


	}

	static class IHereToo {
		static void getThis() {
			System.out.println("Im calling form insider the static class of Child");
		}
	}
}