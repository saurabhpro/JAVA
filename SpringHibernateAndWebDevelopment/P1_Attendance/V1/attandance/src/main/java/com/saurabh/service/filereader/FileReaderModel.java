package com.saurabh.service.filereader;

import java.util.List;
import java.util.Map;

public interface FileReaderModel<T> {
	List<T> getAsList();

	Map<String, T> getAsMap();

	void setAsMap(Map<String, T> map);
}
