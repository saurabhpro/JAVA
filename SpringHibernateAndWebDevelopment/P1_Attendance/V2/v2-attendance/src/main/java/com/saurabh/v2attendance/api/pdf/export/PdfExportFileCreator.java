package com.saurabh.v2attendance.api.pdf.export;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class PdfExportFileCreator {

	public void updatePdfResponseObject(HttpServletResponse response, String pdfFileName) {
		response.setContentType("application/pdf");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "max-age=0");
		response.setHeader("Content-disposition", "attachment; " + "filename=" + pdfFileName);
	}


}