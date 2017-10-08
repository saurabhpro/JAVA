package com.saurabh.view.json_generators;

import com.saurabh.entity.attendence.AttendanceOfADate;
import com.saurabh.service.helper.utility.constants.ProjectConstants;
import com.saurabh.service.helper.utility.constants.enums.AttendanceStatusType;
import com.saurabh.service.helper.utility.constants.enums.HolidaysList;
import com.saurabh.viewmodel.FinalObjectModel;
import com.saurabh.viewmodel.HolidayWorkerModel;
import com.saurabh.viewmodel.ListGeneratorModel;
import com.saurabh.viewmodel.WebJSONModel;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumars on 3/4/2016.
 */
public class PublicHolidayWorkerJson extends ListGeneratorModel {
	private List<HolidayWorkerModel> holidayWorkerList = new ArrayList<>();

	public void generate() {
		for (FinalObjectModel finalObjectModel : allEmpDetails.values()) {
			for (HolidaysList h : HolidaysList.values()) {
				LocalDate publicHolidayDate = h.getDate();

				if (ifRespectiveMonthHasAPublicHoliday(publicHolidayDate.getMonth(), publicHolidayDate)) {
					int changeOnDate = publicHolidayDate.getDayOfMonth() - 1;

					if (employeeWorkedOnPublicHoliday(finalObjectModel.attendanceOfADate[changeOnDate])) {
						HolidayWorkerModel h1 = new WebJSONModel(finalObjectModel).getHolidayWorkerObjForThisDate(changeOnDate);

						if (h1 != null) {
							h1.setHoliday(h);
							holidayWorkerList.add(h1);
						}
					}
				}
			}
		}
	}

	private boolean employeeWorkedOnPublicHoliday(AttendanceOfADate attendance) {
		return attendance.getAttendanceStatusType() == AttendanceStatusType.PUBLIC_HOLIDAY
				&& attendance.getWorkTimeForDay() != null;
	}

	private boolean ifRespectiveMonthHasAPublicHoliday(Month currentMonth, LocalDate publicHolidayDate) {
		return currentMonth == ProjectConstants.getMONTH()
				&& publicHolidayDate.getDayOfMonth() < ProjectConstants.getNumberOfDaysConsideredInRespectiveMonth();
	}

	@Override
	public void displayOnConsole() {
		System.out.println("HOLIDAY LIST HIGHLIGHTED");
		holidayWorkerList.forEach(HolidayWorkerModel::display);
	}


	@Override
	public void createJSONList() {
		super.createJSONFile(ProjectConstants.getPublicHolidayListFile(), holidayWorkerList);
	}

}
