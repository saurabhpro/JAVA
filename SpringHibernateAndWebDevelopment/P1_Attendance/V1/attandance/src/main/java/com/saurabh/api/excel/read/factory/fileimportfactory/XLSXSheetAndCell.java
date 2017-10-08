package com.saurabh.api.excel.read.factory.fileimportfactory;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Saurabh on 3/3/2016.
 */
@Component
public class XLSXSheetAndCell implements CreateSheet<Sheet> {
	private Sheet sheet = null;

	@Override
	public Sheet getSheet(String filePath) {
		try {
			FileInputStream file = new FileInputStream(new File(filePath));
			Workbook workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0); // Get the first sheet
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sheet;
	}
}
