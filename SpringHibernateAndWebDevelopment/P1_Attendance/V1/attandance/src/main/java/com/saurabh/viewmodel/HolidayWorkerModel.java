package com.saurabh.viewmodel;

import com.saurabh.entity.employee.Employee;
import com.saurabh.service.helper.utility.constants.enums.HolidaysList;

/**
 * Created by Saurabh on 3/12/2016.
 */
public class HolidayWorkerModel {
	HolidaysList holiday;
	Employee employee;
	WebJSONModel.PerDayAttendanceRecord perDayAttendanceRecord;

	public HolidayWorkerModel(Employee b, WebJSONModel.PerDayAttendanceRecord s) {
		this.employee = b;
		this.perDayAttendanceRecord = s;
	}

	public Employee getEmployee() {
		return employee;
	}

	public WebJSONModel.PerDayAttendanceRecord getPerDayAttendanceRecord() {
		return perDayAttendanceRecord;
	}

	public HolidaysList getHoliday() {
		return holiday;
	}

	public void setHoliday(HolidaysList holiday) {
		this.holiday = holiday;
	}

	public void display() {
		System.out.println();
		System.out.println(employee);

		perDayAttendanceRecord.displaySub();

		if (holiday != null)
			System.out.println("Holiday is " + holiday.name());
	}
}
