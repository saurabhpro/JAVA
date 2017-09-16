package com.saurabh.view;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * There are 2 file formats in which we can create an Excel document. The .xls is the old format, the .xlsx
 * is the new format which is XML based. We are using apache POI to create excel files,
 * <p>
 * when creating .xls documents make sure the org.apache.poi:poi dependency is on the classpath.
 * <p>
 * When working with .xlsx files, you need the org.apache.poi:poi-ooxml dependency.
 */
public abstract class AbstractXlsxView extends AbstractXlsView {

	/**
	 * Default Constructor.
	 * <p>Sets the content type of the view to
	 * {@code "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"}.
	 */
	public AbstractXlsxView() {
		setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}

	/**
	 * This implementation creates an {@link XSSFWorkbook} for the XLSX format.
	 */
	@Override
	protected Workbook createWorkbook(Map<String, Object> model, HttpServletRequest request) {
		return new XSSFWorkbook();
	}

}