package generics.array;

/**
 * Created by Saurabh on 8/13/2015.
 */
class GenItem<T> {
	private final T item;
	private final T[] val;

	GenItem(T ob, T[] nums) {
		item = ob;
		val = nums;
	}

	void showItems() {
		System.out.println(item + " " + item.getClass().getName());
		for (T i : val) {
			System.out.println(i);
		}
	}
}
