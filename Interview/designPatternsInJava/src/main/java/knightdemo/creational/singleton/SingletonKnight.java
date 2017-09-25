package knightdemo.creational.singleton;

/**
 * @author saurabh
 */
public class SingletonKnight {

	private static SingletonKnight knight;

	private Integer count = 0;

	/**
	 * Private contructor
	 */
	private SingletonKnight() {

	}

	/**
	 * public static getInstance method used to obtain the instance of this class
	 */
	public static SingletonKnight getIntance() {
		if (knight == null) {
			knight = new SingletonKnight();
		}

		return knight;
	}

	public void increaseCount() {
		count++;
	}

	public Integer getCount() {
		return count;
	}

}
