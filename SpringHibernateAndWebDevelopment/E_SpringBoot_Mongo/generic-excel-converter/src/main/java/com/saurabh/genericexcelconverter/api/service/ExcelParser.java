package com.saurabh.genericexcelconverter.api.service;

import com.saurabh.genericexcelconverter.api.model.MonthNotes;

import java.util.List;
import java.util.UnknownFormatConversionException;

public interface ExcelParser {
	List<MonthNotes> parse(int year) throws UnknownFormatConversionException;
}
