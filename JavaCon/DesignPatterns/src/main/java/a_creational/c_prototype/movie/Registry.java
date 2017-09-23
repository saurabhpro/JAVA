package a_creational.c_prototype.movie;

import java.util.HashMap;
import java.util.Map;

class Registry {

	private final Map<String, Item> itemMap = new HashMap<>();

	public Registry() {
		loadItems();
	}

	public Item createItem(String type) {
		Item item = null;

		try {
			//shallow copy
			item = (Item) (itemMap.get(type)).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return item;
	}

	private void loadItems() {
		Movie movie = new Movie();
		movie.setTitle("Basic Movie");
		movie.setPrice(24.99);
		movie.setRuntime("2 hours");
		itemMap.put("Movie", movie);

		Book book = new Book();
		book.setNumberOfPages(335);
		book.setPrice(19.99);
		book.setTitle("Basic Book");
		itemMap.put("Book", book);
	}
}
