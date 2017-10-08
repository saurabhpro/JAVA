package com.saurabh.api.excel.read.factory.fileimportfactory;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Saurabh on 3/3/2016.
 */
@Component
public class XLSSheetAndCell implements CreateSheet<Sheet> {

	private Sheet sheet = null;

	@Override
	public Sheet getSheet(String fileName) {
		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			// Create Workbook instance holding reference to .xlsx file
			Workbook workbook = new HSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			sheet = workbook.getSheetAt(0);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sheet;
	}
}
