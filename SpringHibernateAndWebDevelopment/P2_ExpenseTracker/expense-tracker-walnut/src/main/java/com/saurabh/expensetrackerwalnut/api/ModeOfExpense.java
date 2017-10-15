package com.saurabh.expensetrackerwalnut.api;

import com.saurabh.expensetrackerwalnut.model.helper_enums.Mode;
import org.springframework.stereotype.Component;

@Component
public class ModeOfExpense {
	public static Mode determineModeOfExpense(String modeOfExpense) {
		switch (modeOfExpense) {
			case "CASH Spends":
				return Mode.Cash;
			default:
				return Mode.Card;
		}
	}
}
