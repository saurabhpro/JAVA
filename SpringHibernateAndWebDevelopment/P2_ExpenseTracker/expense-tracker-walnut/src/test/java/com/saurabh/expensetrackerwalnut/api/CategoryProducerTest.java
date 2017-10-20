package com.saurabh.expensetrackerwalnut.api;

import com.saurabh.expensetrackerwalnut.model.helper_enums.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryProducerTest {
	@Test
	void determineCategory() {
		Assertions.assertEquals(Category.Groceries, CategoryProducer.determineCategory("GROCERIES"));
	}

}