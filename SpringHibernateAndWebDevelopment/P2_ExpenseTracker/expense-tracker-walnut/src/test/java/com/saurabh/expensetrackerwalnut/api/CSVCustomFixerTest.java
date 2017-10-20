package com.saurabh.expensetrackerwalnut.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.saurabh.expensetrackerwalnut.service.CSVParserImpl.MISPLACED_COMMA_REPLACEMENT;

class CSVCustomFixerTest {
	@Test
	void fixPlacesArrayFromCSV() {
		String actual = "03-05-16,10:17 PM,\"TANG, BISCUITS\",220,CASH Spends,No,FOOD & DRINKS,,";
		String expected = "03-05-16,10:17 PM,TANG" + MISPLACED_COMMA_REPLACEMENT + " BISCUITS,220,CASH Spends,No,FOOD & DRINKS,,";

		Assertions.assertEquals(expected, CSVCustomFixer.fixPlacesFromCSV(actual));
	}

	@Test
	void fixAmountValueFromCSV() {
		String expected = "20-02-16,12:00 PM,MOTO X PLAY,15999.0,CASH Spends,Yes,SHOPPING,,";
		String actual = "20-02-16,12:00 PM,MOTO X PLAY,\"15,999\",CASH Spends,Yes,SHOPPING,,";

		Assertions.assertEquals(expected, CSVCustomFixer.fixAmountValueFromCSV(actual));
	}

	@Test
	void fixAmountValueFromCSV2() {
		String expected = "24-03-16,02:27 AM,BATMAN V SUPERMAN,1342.4,CitiBank debit 6302,Yes,ENTERTAINMENT,\"#Online, #Friends, #Office\",";
		String actual = "24-03-16,02:27 AM,BATMAN V SUPERMAN,\"1,342.4\",CitiBank debit 6302,Yes,ENTERTAINMENT,\"#Online, #Friends, #Office\",";

		Assertions.assertEquals(expected, CSVCustomFixer.fixAmountValueFromCSV(actual));
	}

	@Test
	void fixTagsArrayFromCSV() {
		String expected = "20-02-16,12:00 PM,DEADPOOL,125,CASH Spends,Yes,ENTERTAINMENT,#Friends- #Office,";
		String actual = "20-02-16,12:00 PM,DEADPOOL,125,CASH Spends,Yes,ENTERTAINMENT,\"#Friends, #Office\",";

		Assertions.assertEquals(expected, CSVCustomFixer.fixTagsArrayFromCSV(actual));
	}

	@Test
	void fixEverythingFromCSVLine() {
		String expected = "24-03-16,02:27 AM,BATMAN V SUPERMAN,1342.4,CitiBank debit 6302,Yes,ENTERTAINMENT,#Online- #Friends- #Office,";
		String actual = "24-03-16,02:27 AM,BATMAN V SUPERMAN,1342.4,CitiBank debit 6302,Yes,ENTERTAINMENT,\"#Online, #Friends, #Office\",";

		Assertions.assertEquals(expected, CSVCustomFixer.fixInputFromCSV(actual));
	}
}