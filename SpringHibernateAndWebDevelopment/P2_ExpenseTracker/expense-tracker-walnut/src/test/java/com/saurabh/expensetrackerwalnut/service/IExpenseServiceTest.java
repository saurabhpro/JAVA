package com.saurabh.expensetrackerwalnut.service;

import com.saurabh.expensetrackerwalnut.model.WalnutRow;
import com.saurabh.expensetrackerwalnut.repository.IExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IExpenseServiceTest {
	private IExpenseService expenseService;

	@Mock
	private IExpenseRepository expenseRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		expenseService = new ExpenseServiceImpl(expenseRepository);
	}

	@Test
	void findTopByOrderByIDDesc() {

	}

	@Test
	void countByIsExpense() {
		// given


		// when


		// then

	}

	@Test
	void findAll() {
		// given
		WalnutRow walnutRow = new WalnutRow();
		List<WalnutRow> rowList = new ArrayList<>();
		walnutRow.setID(22);
		rowList.add(walnutRow);

		// when
		when(expenseService.findAll()).thenReturn(rowList);       // got sample data back
		List<WalnutRow> recipes = expenseService.findAll();

		// then
		assertEquals(recipes.size(), 1);
		assertEquals(recipes.get(0).getID(), 22);

		// verify that the mock class method findAll() was called exactly 1 times
		verify(expenseRepository, times(1)).findAll();
	}

}