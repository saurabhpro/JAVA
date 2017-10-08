package com.saurabh.api.excel.read;

import org.springframework.stereotype.Component;

/**
 * Created by saurabhkumar on 10/09/17.
 */
@Component
public interface ExcelReader<T> {
	T convertToSheet(String filePath);

	void readExcelFile(String filePath);

	void toJsonFile(String filePath);
}
