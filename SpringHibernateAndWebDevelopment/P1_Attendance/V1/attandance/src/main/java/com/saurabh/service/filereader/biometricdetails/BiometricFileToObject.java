package com.saurabh.service.filereader.biometricdetails;

import com.saurabh.api.excel.read.XLSReaderImpl;
import com.saurabh.api.json.JsonWriter;
import com.saurabh.entity.attendence.AttendanceOfADate;
import com.saurabh.entity.records.EmployeeBiometric;
import com.saurabh.service.helper.RevalIdComparator;
import com.saurabh.service.helper.utility.constants.ProjectConstants;
import com.saurabh.service.helper.utility.constants.enums.AttendanceStatusType;
import jxl.Sheet;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static com.saurabh.service.helper.utility.TimeManager.convertToLocalDate;
import static com.saurabh.service.helper.utility.constants.ProjectConstants.FILE_PATH;

/**
 * Created by saurabhkumar on 10/09/17.
 */
public class BiometricFileToObject extends XLSReaderImpl {

	private static AllEmployeeBiometricDetailList allEmployeeBiometricDetailList = new AllEmployeeBiometricDetailList();

	// Variable to store the reference of sheet from workbook of biometric file
	private transient Sheet sheet = null;
	// Variable to add rows after which biometric xls file starts the new users
	// entries
	private transient int ADD_ROW_STEPS = 0;

	public static List<EmployeeBiometric> getAllEmployeeBiometricDetailList() {
		return allEmployeeBiometricDetailList.getAsList();
	}

	public static Map<String, EmployeeBiometric> getAllEmployeeBiometricDetailMap() {
		return allEmployeeBiometricDetailList.getAsMap();
	}


	/*
	 * Method to display the contents read till reading of the Biometric file
	 *
	 * @implNote Remove this from the production release version
	 */
	/*@Override
	public void displayFile() {
		System.out.println(ProjectConstants.getMONTH());
		empBiometricMap.values().forEach(System.out::println);
	}*/

	@Override
	public void readExcelFile(String filePath) {
		sheet = super.convertToSheet(filePath);

		int numberOfRowsInBio = (sheet.getRows() - 11) / 18;

		// local data
		String empId, empName;
		AttendanceOfADate[] attendanceOfADate;

		Map<String, EmployeeBiometric> employeeBiometricDetailsList = new TreeMap<>(new RevalIdComparator());

		EmployeeBiometric obj;

		// Set Global Month and Year
		String monthYear = getCustomCellContent(13, 7);
		String[] temp = monthYear.split(" {3}");
		ProjectConstants.setMONTH(Month.valueOf(temp[0].toUpperCase()));
		ProjectConstants.setYEAR(Year.parse(temp[1]));

		//set file generation date
		ProjectConstants.setBiometricFileGenerationDate(convertToLocalDate(getCustomCellContent(11, 5), "d/m/y"));

		for (int i = 0; i < numberOfRowsInBio; i++) {
			empName = getCustomCellContent(3, 13 + (18 * ADD_ROW_STEPS));
			empId = getCustomCellContent(3, 15 + (18 * ADD_ROW_STEPS));

			attendanceOfADate = new AttendanceOfADate[ProjectConstants.getNumberOfDaysConsideredInRespectiveMonth()];
			getMonthlyAttendanceOfEmployee(attendanceOfADate); // referenced

			obj = new EmployeeBiometric(empId, empName, attendanceOfADate);

			employeeBiometricDetailsList.put(empId, obj);

			ADD_ROW_STEPS++;
		}
		allEmployeeBiometricDetailList.setAsMap(employeeBiometricDetailsList);
	}

	/**
	 * @param column the column number starting from 0 from which data is to be
	 *               retrieved
	 * @param row    the row number stating with 0 from which data is to be
	 *               retrieved
	 * @return return the contents for the cell specified by column and row
	 */
	private String getCustomCellContent(int column, int row) {
		return sheet.getCell(column, row).getContents().trim();
	}

	/**
	 * method to retrieve the attendance for an employee for that month
	 *
	 * @param attendanceOfADate Empty object that will hold all dates information
	 *                          as array, since it is pass by reference expected behavior is
	 *                          that after the method ends, we will have a filled object
	 *                          without need to return anything from method
	 */
	private void getMonthlyAttendanceOfEmployee(AttendanceOfADate[] attendanceOfADate) {
		StringTokenizer st;
		AttendanceStatusType attendanceStatus;

		for (int k = 0; k < ProjectConstants.getNumberOfDaysConsideredInRespectiveMonth(); k++) {
			LocalTime checkIn = null;
			LocalTime checkOut = null;
			attendanceStatus = AttendanceStatusType.ABSENT; // default attendance status for
			// an employee

			//noinspection StringTokenizerDelimiter
			st = new StringTokenizer(getCustomCellContent(k, 20 + (18 * ADD_ROW_STEPS)), "   ");

			lb:
			for (int j = 2; j < 6; j++) {
				String tempString;
				if (st.hasMoreElements()) {
					tempString = ((String) st.nextElement()).trim();
					// A
					// 11:00 12:00 00;00 P
					switch (tempString) {
						case "A":
						case "A/A":
						case "P/A":

							attendanceStatus = AttendanceStatusType.ABSENT;
							break lb;

					/* Removing this case due to addition of night shift,
					due to which the system now counts saturday as A and monday as W
					Also we are adding the attendance status of weekend by checking for
					saturday and sunday later so this case is moot
					*/
						case "W":
							// case when employeemodal checks in on weekend
							/*attendanceStatus = WEEKEND_HOLIDAY;*/
							break lb;

						case "A/P":    //this case was considered as present because Amrita said that Saurabh is completely and utterly mad
						case "P":
							attendanceStatus = AttendanceStatusType.PRESENT;
							break lb;

						default:
							if (j == 2)
								checkIn = LocalTime.parse(tempString);
							else if (j == 3)
								checkOut = LocalTime.parse(tempString);
					}
				}
			}

			LocalDate currentDate = LocalDate.of(ProjectConstants.getYEAR().getValue(), ProjectConstants.getMONTH(), (k + 1));
			attendanceOfADate[k] = new AttendanceOfADate(currentDate, checkIn, checkOut, attendanceStatus);
		}
	}

	/**
	 * method to convert the object map containing the all employees basic data
	 * record to Json files
	 */
	@Override
	public void toJsonFile(String filePath) {
		JsonWriter.writeUsingJackson(FILE_PATH + filePath, allEmployeeBiometricDetailList);
	}
}
