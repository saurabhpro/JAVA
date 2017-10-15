package com.saurabh.expensetrackerwalnut.bootstrap;

import com.saurabh.expensetrackerwalnut.model.WalnutRow;
import com.saurabh.expensetrackerwalnut.repository.ExpenseTable;
import com.saurabh.expensetrackerwalnut.service.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private ExpenseTable expenseTable;
	private CSVParser<WalnutRow> csvParser;

	@Autowired
	public DevBootstrap(ExpenseTable expenseTable, CSVParser<WalnutRow> csvParser) {
		this.expenseTable = expenseTable;
		this.csvParser = csvParser;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

	private void initData() {
		//this.csvParser.parseCSVBody(CSVParser.fileName).forEach((row)-> this.expenseTable.save(row));
		List<WalnutRow> walnutRowList = this.csvParser.parseCSVBody(CSVParser.fileName);

		this.expenseTable.saveAll(walnutRowList);
	}

}