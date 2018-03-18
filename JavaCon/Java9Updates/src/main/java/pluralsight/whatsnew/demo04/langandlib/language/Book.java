/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.whatsnew.demo04.langandlib.language;

public class Book implements PricedObject {

	String title;
	double price;

	public Book(String title, double price) {
		this.title = title;
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

}
