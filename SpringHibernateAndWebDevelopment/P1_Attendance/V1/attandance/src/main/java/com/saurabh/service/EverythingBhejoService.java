package com.saurabh.service;

import com.saurabh.view.json_generators.AllEmployeeDetailsJson;
import com.saurabh.viewmodel.WebJSONModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saurabhkumar on 10/09/17.
 */
@Service
public class EverythingBhejoService {
	private final AllEmployeeDetailsJson allEmployeeDetailsJson;

	@Autowired
	public EverythingBhejoService(AllEmployeeDetailsJson allEmployeeDetailsJson) {
		this.allEmployeeDetailsJson = allEmployeeDetailsJson;
	}

	public List<WebJSONModel> getAllEmployees() {
		allEmployeeDetailsJson.generate();
		return allEmployeeDetailsJson.getList();
	}
}
