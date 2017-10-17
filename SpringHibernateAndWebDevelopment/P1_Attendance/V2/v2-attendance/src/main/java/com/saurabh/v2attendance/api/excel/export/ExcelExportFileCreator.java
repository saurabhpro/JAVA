package com.saurabh.v2attendance.api.excel.export;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ExcelExportFileCreator {

	public void updateExcelResponseObject(HttpServletResponse response, String excelFileName) {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=" + excelFileName);
	}
}