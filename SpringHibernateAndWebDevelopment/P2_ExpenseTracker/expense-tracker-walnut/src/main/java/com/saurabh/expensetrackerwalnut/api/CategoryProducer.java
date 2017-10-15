package com.saurabh.expensetrackerwalnut.api;

import com.saurabh.expensetrackerwalnut.model.helper_enums.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryProducer {

	public static Category determineCategory(String category) {

		switch (category) {
			case "BILLS":
				return Category.Bills;
			case "SHOPPING":
				return Category.Shopping;
			case "FOOD & DRINKS":
				return Category.FoodAndDrinks;
			case "GROCERIES":
				return Category.Groceries;
			case "TRANSFER":
				return Category.Transfer;
			case "INVESTMENT":
			case "SAVINGS":
				return Category.Savings;
			case "TRAVEL":
				return Category.Travel;
			case "ENTERTAINMENT":
				return Category.Movies;
			default:
				return Category.Misc;
		}
	}

}
