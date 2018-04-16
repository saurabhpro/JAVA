package com.saurabh.genericexcelconverter.api.service;

import org.apache.poi.ss.usermodel.Sheet;

import java.nio.file.Path;

public interface CreateSheet<T> {
	Sheet getSheet(Path filePath);
}
