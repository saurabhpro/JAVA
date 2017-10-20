package com.saurabh.expensetrackerwalnut.repository;

import com.saurabh.expensetrackerwalnut.model.WalnutRow;
import com.saurabh.expensetrackerwalnut.service.CSVParser;
import com.saurabh.expensetrackerwalnut.service.CSVParserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ExtendWith(SpringExtension.class)
@DataJpaTest
		// since java 9 add this in vm options as jaxb is not included by default "--add-modules=java.xml.bind"
class IExpenseRepositoryTestIT {

	private static List<WalnutRow> walnutRowList;
	@Autowired
	public IExpenseRepository expenseRepository;

	@BeforeAll
	static void loadData() {
		CSVParser<WalnutRow> csvParser = new CSVParserImpl();
		walnutRowList = csvParser.parseCSVBody(CSVParser.fileName);
	}

	@BeforeEach
	void setUp() {
		this.expenseRepository.saveAll(walnutRowList);
	}

	@Test
	void findTopByOrderByIDDesc() throws ExecutionException, InterruptedException, TimeoutException {
		Future<WalnutRow> walnutRow = expenseRepository.findTopByOrderByIDDesc();

		Assertions.assertEquals(502, walnutRow.get(1000, TimeUnit.MICROSECONDS).getID());
	}

	@Test
	void countByIsExpense() {
		long count = expenseRepository.countByIsExpense(true);

		Assertions.assertEquals(280, count);
	}

}