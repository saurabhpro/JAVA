package com.saurabh.view.json_generators;

import com.saurabh.service.helper.RevalIdComparator;
import com.saurabh.service.helper.utility.constants.ProjectConstants;
import com.saurabh.viewmodel.FinalObjectModel;
import com.saurabh.viewmodel.ListGeneratorModel;
import com.saurabh.viewmodel.WebJSONModel;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

/**
 * Created by kumars on 3/11/2016.
 */
@Component
public class OnlyDiscrepancyDetailsJson extends ListGeneratorModel {
	@Override
	public void generate() {
		WebJSONModel webJSONModel;
		filteredEmpDetails = new TreeMap<>(new RevalIdComparator());
		for (FinalObjectModel f : allEmpDetails.values()) {
			if (f.getIfClarificationNeeded()) {
				webJSONModel = new WebJSONModel(f, ProjectConstants.DISCREPANCY_IN_WORKERS_LIST);
				filteredEmpDetails.put(f.getEmpId(), webJSONModel);
			}
		}
	}

	@Override
	public void createJSONList() {
		super.createJSONFile(ProjectConstants.DISCREPANCY_IN_WORKERS_LIST, getList());
	}
}
