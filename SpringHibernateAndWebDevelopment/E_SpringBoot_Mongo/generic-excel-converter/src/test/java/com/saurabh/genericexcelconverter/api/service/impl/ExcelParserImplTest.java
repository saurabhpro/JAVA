package com.saurabh.genericexcelconverter.api.service.impl;

import com.saurabh.genericexcelconverter.api.constants.MessageConstants;
import com.saurabh.genericexcelconverter.api.model.MonthNotes;
import com.saurabh.genericexcelconverter.api.service.ExcelParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class ExcelParserImplTest {

	private ExcelParser delegate = new ExcelParserImpl();

	@Test
	void parse() {
		final List<MonthNotes> parse = delegate.parse(2007);

		Assertions.assertNotNull(parse);
	}

	@Test
	void getContent() {
		Path expected = Paths.get("./src/main/resources/excel-repo/year 2007 for saurabh.xlsx");

		Path actual = Paths.get(MessageConstants.getFileName(2007)).normalize().toAbsolutePath();

		Assertions.assertEquals(expected.toAbsolutePath().normalize(), actual);
	}

	@Test
	void parse1() {
		final List<MonthNotes> parse = delegate.parse(2008);

		Assertions.assertNotNull(parse);
	}

	@Test
	void getContent2() {
		Path expected = Paths.get("./src/main/resources/excel-repo/What's Your Life in 2008.xlsx");
		Path actual = Paths.get(MessageConstants.getFileName(2008)).normalize().toAbsolutePath();

		Assertions.assertEquals(expected.toAbsolutePath().normalize(), actual);
	}
}