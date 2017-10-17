package com.saurabh.v2attendance.api.excel.read.factory.fileimportfactory;


import org.springframework.stereotype.Component;

/**
 * Created by saurabhkumar on 10/09/17.
 */
@Component
public interface CreateSheet<T> {
	T getSheet(String filePath);
}
