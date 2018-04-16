package com.saurabh.genericexcelconverter.api.service.impl;

import com.saurabh.genericexcelconverter.api.service.CreateSheet;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class XLSXSheetCreator implements CreateSheet<Sheet> {
	private Sheet sheet = null;

	@Override
	public Sheet getSheet(Path filePath) {
		try {
			FileInputStream file = new FileInputStream(filePath.toFile());
			Workbook workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0); // Get the first sheet
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sheet;
	}
}