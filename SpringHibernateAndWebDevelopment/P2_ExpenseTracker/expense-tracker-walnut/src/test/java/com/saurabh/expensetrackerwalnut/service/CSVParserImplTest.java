package com.saurabh.expensetrackerwalnut.service;


import com.saurabh.expensetrackerwalnut.model.WalnutRow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

class CSVParserImplTest {
	private final Logger logger = LoggerFactory.getLogger(CSVParserImplTest.class);

	private CSVParser<WalnutRow> csvParser;

	@BeforeEach
	void setUp() {
		csvParser = new CSVParserImpl();
	}

	@Test
	void parseCsv() {
		List<WalnutRow> walnutRowList = csvParser.parseCSVBody(CSVParser.fileName);
		logger.info(walnutRowList::toString);

		Assertions.assertNotNull(walnutRowList, "Do you see that csv file read failed!");
	}

	@Test
	void parseHeader() {
		csvParser.parseCSVHeader(CSVParser.fileName);

		Assertions.assertEquals(LocalDate.parse("2016-02-01"), CSVParserImpl.fromDate);
		Assertions.assertEquals(LocalDate.parse("2017-07-31"), CSVParserImpl.toDate);
	}

}