package com.saurabh.expensetrackerwalnut.controller;

import com.saurabh.expensetrackerwalnut.model.WalnutRow;
import com.saurabh.expensetrackerwalnut.repository.ExpenseTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class HomeController {
	private final ExpenseTable expenseTable;

	@Autowired
	public HomeController(ExpenseTable expenseTable) {
		this.expenseTable = expenseTable;
	}

	@GetMapping("/")
	public List<WalnutRow> getAllRows() {
		return (List<WalnutRow>) this.expenseTable.findAll();
	}

	@GetMapping("/last")
	public WalnutRow getLastRow() throws ExecutionException, InterruptedException {
		return this.expenseTable.findTopByOrderByIDDesc().get();
	}
}
