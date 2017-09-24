package Ch10_Sorting_and_Searching.Q10_04_Sorted_Search_No_Size.Arrayish;

class Listy {
	private final int[] array;

	public Listy(int[] arr) {
		array = arr.clone();
	}

	public int elementAt(int index) {
		if (index >= array.length) {
			return -1;
		}
		return array[index];
	}
}
