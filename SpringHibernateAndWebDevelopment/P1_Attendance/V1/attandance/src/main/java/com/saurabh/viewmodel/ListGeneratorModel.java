package com.saurabh.viewmodel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saurabh.service.combine_logic.FinalObject;
import com.saurabh.service.helper.utility.constants.ProjectConstants;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.saurabh.service.helper.utility.constants.ProjectConstants.FILE_PATH;

/**
 * Created by Saurabh on 3/12/2016.
 */
public abstract class ListGeneratorModel {
	//to init everything
	protected final Map<String, FinalObjectModel> allEmpDetails = FinalObject.getEmpCombinedMap();

	protected Map<String, WebJSONModel> filteredEmpDetails;

	public abstract void generate();

	public abstract void createJSONList();

	public void displayOnConsole() {
		filteredEmpDetails.values().forEach(WebJSONModel::displayAllDates);
	}

	protected <T> void createJSONFile(String fileName, List<T> listData) {
		ObjectMapper mapper = new ObjectMapper();
		// For testing
		//List<WebJSONModel> user = new ArrayList<>(filteredEmpDetails.values());
		try {
			File jfile = new File(getFilePath(fileName));
			/*
			 * System.out.println(jfile.getAbsolutePath());
			 * System.out.println(jfile.getCanonicalPath());
			 * System.out.println(jfile.getParent());
			 */

			// Convert object to JSON string and save into file directly
			mapper.writeValue(jfile, listData);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getFilePath(String fileName) {
		return FILE_PATH + "json_files" + ProjectConstants.FILE_SEPARATOR + fileName + ".json";
	}

	public List<WebJSONModel> getList() {
		return new ArrayList<>(filteredEmpDetails.values());
	}
}
