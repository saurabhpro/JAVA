package a_creational.d_factory.website.shop;

import a_creational.d_factory.website.Website;

public class Shop extends Website {

	@Override
	public void createWebsite() {
		pages.add(new CartPage());
		pages.add(new ItemPage());
		pages.add(new SearchPage());
	}

}
