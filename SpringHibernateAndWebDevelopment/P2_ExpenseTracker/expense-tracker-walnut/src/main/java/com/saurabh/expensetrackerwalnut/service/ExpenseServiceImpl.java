package com.saurabh.expensetrackerwalnut.service;

import com.saurabh.expensetrackerwalnut.model.WalnutRow;
import com.saurabh.expensetrackerwalnut.repository.IExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class ExpenseServiceImpl implements IExpenseService {
	private IExpenseRepository IExpenseRepository;

	@Autowired
	public ExpenseServiceImpl(IExpenseRepository IExpenseRepository) {
		this.IExpenseRepository = IExpenseRepository;
	}

	@Override
	public WalnutRow findTopByOrderByIDDesc() {
		Future<WalnutRow> rowFuture = IExpenseRepository.findTopByOrderByIDDesc();

		WalnutRow walnutRow = null;
		try {
			walnutRow = rowFuture.get(1000, TimeUnit.MICROSECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}

		return walnutRow;
	}

	@Override
	public long countByIsExpense() {
		return this.IExpenseRepository.countByIsExpense(true);
	}

	@Override
	public List<WalnutRow> findAll() {

		return (List<WalnutRow>) this.IExpenseRepository.findAll();
	}
}
