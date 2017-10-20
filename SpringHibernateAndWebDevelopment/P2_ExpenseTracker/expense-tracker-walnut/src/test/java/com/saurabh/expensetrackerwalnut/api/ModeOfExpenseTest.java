package com.saurabh.expensetrackerwalnut.api;

import com.saurabh.expensetrackerwalnut.model.helper_enums.Mode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ModeOfExpenseTest {
	@Test
	void determineModeOfExpense() {
		Assertions.assertEquals(Mode.Cash, ModeOfExpense.determineModeOfExpense("CASH Spends"));
	}

}