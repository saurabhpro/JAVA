package a_creational.d_factory;

import java.util.Calendar;

import static java.util.Calendar.*;

public class FactoryEverydayDemo {

	public static void main(String args[]) {

		Calendar cal = Calendar.getInstance();
		//Calendar cal = Calendar.get

		System.out.println(cal);

		System.out.println(cal.get(Calendar.DAY_OF_MONTH));


		//after java 8, calender has builders
		Calendar cal2 = new Calendar.Builder().setCalendarType("japanese").setFields(YEAR, 1, DAY_OF_YEAR, 1).build();
		System.out.println(cal2);
		cal2 = new Calendar.Builder().setCalendarType("iso8601").setWeekDate(2013, 1, MONDAY).build();
		System.out.println(cal2);
	}

}
