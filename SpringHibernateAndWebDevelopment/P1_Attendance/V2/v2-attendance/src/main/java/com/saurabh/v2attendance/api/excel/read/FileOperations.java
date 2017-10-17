package com.saurabh.v2attendance.api.excel.read;

import org.springframework.stereotype.Component;

/**
 * Created by saurabhkumar on 10/09/17.
 */
@Component
public interface FileOperations {
	void readExcelFile(String filePath);
}
