package com.saurabh.v2attendance.api.excel.read;

import com.saurabh.v2attendance.api.excel.read.factory.fileimportfactory.JXLSSheetAndCell;
import jxl.Sheet;
import org.springframework.stereotype.Component;

/**
 * Created by saurabhkumar on 10/09/17.
 */
@Component
public abstract class XLSReaderImpl implements FileOperations, ExcelReader<Sheet> {

	@Override
	public Sheet convertToSheet(String filePath) {
		return new JXLSSheetAndCell().getSheet(filePath);
	}

}
