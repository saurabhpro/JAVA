package com.saurabh.view;

import com.saurabh.model.User;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * ExcelView which extends from AbstractXlsxView. We create the excel document by overriding the buildExcelDocument()
 * <p>
 * Spring also provides 2 other abstract classes AbstractXlsView (to create xls file) and AbstractXlsxStreamingView to create xlsx files.
 * When working with large excel documents it is profitable to use the streaming xlsx view. The streaming view uses
 * less memory and can improve performance of large excel documents.
 */
public class ExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
	                                  Workbook workbook,
	                                  HttpServletRequest request,
	                                  HttpServletResponse response) throws Exception {

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xlsx\"");

		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) model.get("users");

		// create excel xls sheet
		Sheet sheet = workbook.createSheet("User Detail");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true);
		font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
		style.setFont(font);


		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Firstname");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("LastName");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Age");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Job Title");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Company");
		header.getCell(4).setCellStyle(style);
		header.createCell(5).setCellValue("Address");
		header.getCell(5).setCellStyle(style);
		header.createCell(6).setCellValue("City");
		header.getCell(6).setCellStyle(style);
		header.createCell(7).setCellValue("Country");
		header.getCell(7).setCellStyle(style);
		header.createCell(8).setCellValue("Phone Number");
		header.getCell(8).setCellStyle(style);


		int rowCount = 1;

		for (User user : users) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellValue(user.getFirstName());
			userRow.createCell(1).setCellValue(user.getLastName());
			userRow.createCell(2).setCellValue(user.getAge());
			userRow.createCell(3).setCellValue(user.getJobTitle());
			userRow.createCell(4).setCellValue(user.getCompany());
			userRow.createCell(5).setCellValue(user.getAddress());
			userRow.createCell(6).setCellValue(user.getCity());
			userRow.createCell(7).setCellValue(user.getCountry());
			userRow.createCell(8).setCellValue(user.getPhoneNumber());

		}
	}
}
