package com.saurabh.api.excel.read.factory.fileimportfactory;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by kumars on 3/3/2016.
 */
@Component
public class JXLSSheetAndCell implements CreateSheet<Sheet> {
	private Sheet sheet = null;

	@Override
	public Sheet getSheet(String filePath) {
		try {
			File inputWorkbook = new File(filePath);
			Workbook w = Workbook.getWorkbook(inputWorkbook);
			sheet = w.getSheet(0); // Get the first sheet
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		return sheet;
	}
}
