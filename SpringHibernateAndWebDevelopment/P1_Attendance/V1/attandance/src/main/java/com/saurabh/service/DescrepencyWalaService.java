package com.saurabh.service;

import com.saurabh.view.json_generators.OnlyDiscrepancyDetailsJson;
import com.saurabh.viewmodel.WebJSONModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saurabhkumar on 10/09/17.
 */
@Service
public class DescrepencyWalaService {
	private final OnlyDiscrepancyDetailsJson onlyDiscrepancyDetailsJson;

	@Autowired
	public DescrepencyWalaService(OnlyDiscrepancyDetailsJson onlyDiscrepancyDetailsJson) {
		this.onlyDiscrepancyDetailsJson = onlyDiscrepancyDetailsJson;
	}

	public List<WebJSONModel> getOnlyDescrepenciesList() {
		onlyDiscrepancyDetailsJson.generate();
		return onlyDiscrepancyDetailsJson.getList();
	}
}
