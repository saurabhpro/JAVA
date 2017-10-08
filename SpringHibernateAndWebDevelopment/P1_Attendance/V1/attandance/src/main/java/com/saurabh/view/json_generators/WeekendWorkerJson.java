package com.saurabh.view.json_generators;

import com.saurabh.entity.attendence.AttendanceOfADate;
import com.saurabh.service.helper.RevalIdComparator;
import com.saurabh.service.helper.utility.constants.ProjectConstants;
import com.saurabh.service.helper.utility.constants.enums.AttendanceStatusType;
import com.saurabh.viewmodel.FinalObjectModel;
import com.saurabh.viewmodel.ListGeneratorModel;
import com.saurabh.viewmodel.WebJSONModel;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

/**
 * Created by Saurabh on 4/8/2016.
 *
 * @version 1.1
 * @since 1.0 added revalidcomparator
 */
@Component
public class WeekendWorkerJson extends ListGeneratorModel {

	public void generate() {
		WebJSONModel webJSONModel;
		filteredEmpDetails = new TreeMap<>(new RevalIdComparator());

		for (FinalObjectModel f : allEmpDetails.values()) {
			for (AttendanceOfADate a : f.attendanceOfADate) {
				if (a.getAttendanceStatusType().equals(AttendanceStatusType.WEEKEND_HOLIDAY) && a.getWorkTimeForDay() != null) {
					// advantage of this check is additional redundant objects
					// are not stored in the filteredEmpDetails
					webJSONModel = new WebJSONModel(f, ProjectConstants.WEEKEND_WORKERS_LIST);
					filteredEmpDetails.put(f.getEmpId(), webJSONModel);
				}
			}
		}
	}

	@Override
	public void createJSONList() {
		super.createJSONFile(ProjectConstants.WEEKEND_WORKERS_LIST, getList());
	}
}
