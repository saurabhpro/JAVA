package com.saurabh.api.excel.exceltypematcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Saurabh on 3/3/2016.
 */

public interface ExcelFileType {

	default String excelVersion(String fileName) {
		Pattern xls = Pattern.compile("[a-zA-Z]+(\\.(xls))");
		Matcher matcher = xls.matcher(fileName);
		if (matcher.matches())
			return "XLS";

		xls = Pattern.compile("[a-zA-Z]+(\\.(xlsx))");
		matcher = xls.matcher(fileName);
		if (matcher.matches())
			return "XLSX";

		return null;
	}
}
