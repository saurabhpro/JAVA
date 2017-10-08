package com.saurabh.service;

import com.saurabh.view.json_generators.WeekendWorkerJson;
import com.saurabh.viewmodel.WebJSONModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saurabhkumar on 10/09/17.
 */
@Service
public class WeekendPeKaamKarneWalaService {
	private final
	WeekendWorkerJson weekendWorkerJson;

	@Autowired
	public WeekendPeKaamKarneWalaService(WeekendWorkerJson weekendWorkerJson) {
		this.weekendWorkerJson = weekendWorkerJson;
	}

	public List<WebJSONModel> getWeekendWorkersList() {
		weekendWorkerJson.generate();
		return weekendWorkerJson.getList();
	}
}
