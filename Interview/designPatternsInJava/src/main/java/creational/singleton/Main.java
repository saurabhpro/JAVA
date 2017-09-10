package creational.singleton;

/**
 * @author saurabh
 *         <p>
 *         Singleton pattern test.
 *         <p>
 *         Calling singleton method twice increasing count by two.
 */
public class Main {

	public static void main(String[] args) {
		// remember in countStart
		Integer countStart = SingletonKnight.getIntance().getCount();

		// call increase
		SingletonKnight.getIntance().increaseCount();// count is one
		// call increase
		SingletonKnight.getIntance().increaseCount();// count is two

		// remember in countEnd
		Integer countEnd = SingletonKnight.getIntance().getCount();

		System.out.println("Start : " + countStart + ", End: " + countEnd);// 0 2
	}

}
