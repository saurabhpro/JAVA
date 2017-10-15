package com.saurabh.expensetrackerwalnut.repository;

import com.saurabh.expensetrackerwalnut.model.WalnutRow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.concurrent.Future;

@Repository
public interface ExpenseTable extends CrudRepository<WalnutRow, Integer> {
	@Async
	Future<WalnutRow> findTopByOrderByIDDesc();

	long countByExpense(boolean expense);
}
