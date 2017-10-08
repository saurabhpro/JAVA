package com.saurabh.api.excel.read;

import com.saurabh.api.excel.read.factory.fileimportfactory.XLSXSheetAndCell;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;

/**
 * Created by saurabhkumar on 10/09/17.
 */

@Component
public abstract class XLSXReaderImpl implements FileOperations, ExcelReader<Sheet> {

	@Override
	public Sheet convertToSheet(String filePath) {
		System.out.println(filePath);
		return new XLSXSheetAndCell().getSheet(filePath);
	}
}
