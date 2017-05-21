package utils;

import map.pluralsight.product.model.Product;
import map.pluralsight.product.model.ProductFixtures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by saurabhkumar on 20/05/17.
 */
public class UnmodifiableShoppingBasket {
	private final List<Product> items = new ArrayList<>();
	private int totalWeight;

	public static void main(String[] args) {
		UnmodifiableShoppingBasket shoppingBasket = new UnmodifiableShoppingBasket();
		shoppingBasket.addMyProduct(ProductFixtures.floorPanel);
		System.out.println(shoppingBasket);

		shoppingBasket.getItems().add(ProductFixtures.door);
		//only view is unmodifiable, you can always addMyProduct() as ArrayList is mutable
		System.out.println(shoppingBasket);
	}

	private void addMyProduct(Product newItem) {
		items.add(newItem);
		totalWeight += newItem.getWeight();
	}

	private List<Product> getItems() {
		//return  items;

		return Collections.unmodifiableList(items);     //fail fast exception is tried to modify this list
	}

	@Override
	public String toString() {
		return "Shoping basket of " + items + " with wright = " + totalWeight;
	}
}
