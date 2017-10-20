package com.saurabh.expensetrackerwalnut.controller;

import com.saurabh.expensetrackerwalnut.model.WalnutRow;
import com.saurabh.expensetrackerwalnut.service.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class HomeController {
	private IExpenseService expenseService;

	@Autowired
	public HomeController(IExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/")
	public List<WalnutRow> getAllRows() {
		return this.expenseService.findAll();
	}

	@GetMapping("/last")
	public WalnutRow getLastRow() throws ExecutionException, InterruptedException {
		return this.expenseService.findTopByOrderByIDDesc();
	}

	@GetMapping("/count")
	public long getExpenseCount() {
		return this.expenseService.countByIsExpense();
	}
}
