package com.saurabh.expensetrackerwalnut.service;

import com.saurabh.expensetrackerwalnut.model.WalnutRow;

import java.util.List;

public interface IExpenseService {
	WalnutRow findTopByOrderByIDDesc();

	long countByIsExpense();

	List<WalnutRow> findAll();
}
