package com.saurabh.service.filereader.salesforce;

import com.saurabh.api.excel.read.XLSXReaderImpl;
import com.saurabh.api.json.JsonWriter;
import com.saurabh.entity.attendence.AttendanceOfLeave;
import com.saurabh.entity.records.EmployeeSalesforce;
import com.saurabh.service.helper.RevalIdComparator;
import com.saurabh.service.helper.utility.TimeManager;
import com.saurabh.service.helper.utility.constants.enums.LeaveType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static com.saurabh.service.helper.utility.constants.ProjectConstants.*;

/**
 * Created by saurabhkumar on 10/09/17.
 */
@Component
public class SalesforceFileToObject extends XLSXReaderImpl {

	private static AllEmployeeSalesforceDetailList allEmployeeSalesforceDetailList = new AllEmployeeSalesforceDetailList();

	public static Map<String, EmployeeSalesforce> getSalesforceDetailsMap() {
		return allEmployeeSalesforceDetailList.getAsMap();
	}

	public List<EmployeeSalesforce> getAllEmployeeSalesforceDetailList() {
		return allEmployeeSalesforceDetailList.getAsList();
	}

	private String getID(Cell cell) {
		//TODO rename getCellTypeEnum to getCellType if apace.poi > 4.2
		if (cell.getCellTypeEnum() == CellType.STRING)
			return cell.getStringCellValue().trim();
		else
			return Objects.toString((int) cell.getNumericCellValue()).trim();
	}

	private LocalDate getLocalDate(Cell cell) {
		//TODO rename getCellTypeEnum to getCellType if apace.poi > 4.2
		if (cell.getCellTypeEnum() == CellType.NUMERIC)
			return TimeManager.convertToLocalDate(new SimpleDateFormat("MM/dd/yyyy").format(cell.getDateCellValue()), "m/d/y");
		else
			return TimeManager.convertToLocalDate(cell.getStringCellValue(), "m/d/y");
	}

	private void leaveStartEndDayRangeFixer(AttendanceOfLeave attendanceOfLeave) {
		/*
		  case where leave applied from 29th jan to 5th feb, and we are
		  calculating for Feb
		 */
		if (attendanceOfLeave.getEndDate().getMonth().equals(getMONTH())
				&& !attendanceOfLeave.getStartDate().getMonth().equals(getMONTH()))
			attendanceOfLeave.setStartDate(LocalDate.of(getYEAR().getValue(), getMONTH(), 1));

		/*
		  case where leave applied from 29th jan to 5th feb, and we are
		  calculating for Jan
		 */
		else if (attendanceOfLeave.getStartDate().getMonth().equals(getMONTH())
				&& !attendanceOfLeave.getEndDate().getMonth().equals(getMONTH()))
			attendanceOfLeave.setEndDate(LocalDate.of(getYEAR().getValue(), getMONTH(), getNumberOfDaysConsideredInRespectiveMonth()));

		/*
		  case where leave applied from 8th jan to 14th jan, and we are
		  calculating for feb
		 */
		else if (!attendanceOfLeave.getStartDate().getMonth().equals(getMONTH())
				&& !attendanceOfLeave.getEndDate().getMonth().equals(getMONTH()))
			attendanceOfLeave.setStartDate(null);

	}

	/**
	 * method to convert the object map containing the all employees basic data
	 * record to Json files
	 */
	public void toJsonFile(String filePath) {
		JsonWriter.writeUsingJackson(FILE_PATH + filePath, allEmployeeSalesforceDetailList);
	}

	@Override
	public void readExcelFile(String filePath) {
		Sheet sheet = super.convertToSheet(filePath);

		Map<String, EmployeeSalesforce> salesforceDetailsMap = new TreeMap<>(new RevalIdComparator());

		int numberOfRowsInHr = sheet.getPhysicalNumberOfRows();

		Cell cell;
		String empName = null;
		String salesForceID = null;
		LocalDate tempDate;

		AttendanceOfLeave attendanceOfLeave;

		for (int i = 1; i < numberOfRowsInHr; i++) {
			attendanceOfLeave = new AttendanceOfLeave();

			for (int j = 0; j < 7; j++) {
				// Update the value of cell
				cell = sheet.getRow(i).getCell(j);

				switch (j) {
					case 0:
						salesForceID = getID(cell);
						break;

					case 1:
						empName = cell.getStringCellValue().trim();
						break;

					case 2:
						String tmp = cell.getStringCellValue().replace(" ", "_").toUpperCase();
						for (LeaveType leaveType : LeaveType.values())
							if (Objects.equals(leaveType.toString(), tmp)) {
								attendanceOfLeave.setLeaveType(LeaveType.valueOf(tmp));
								break;
							}
						break;
					case 3:// startdate column
						tempDate = getLocalDate(cell);
						attendanceOfLeave.setStartDate(tempDate);
						break;
					case 4:// end date column
						tempDate = getLocalDate(cell);
						attendanceOfLeave.setEndDate(tempDate);
						break;

					case 5:
						attendanceOfLeave.setAbsenceTime(cell.getNumericCellValue());
						break;

				}
			}

			// method to only consider leaves for month specified by biometric
			// file
			leaveStartEndDayRangeFixer(attendanceOfLeave);

			// only consider the salesforce data for those months which is on
			// biometric excel
			if (attendanceOfLeave.getStartDate() != null && attendanceOfLeave.getLeaveType() != null) {
				ArrayList<AttendanceOfLeave> tempArrLst;
				// case where employee entry present in map
				// i.e. employee id is already read once form SalesForce
				// file
				if (!salesforceDetailsMap.isEmpty() && salesforceDetailsMap.containsKey((salesForceID))) {
					EmployeeSalesforce emp = salesforceDetailsMap.get(salesForceID);

					tempArrLst = (ArrayList<AttendanceOfLeave>) emp.getAttendanceOfLeaveList();
					tempArrLst.add(attendanceOfLeave);
					emp.setAttendanceOfLeaveList(tempArrLst);

					salesforceDetailsMap.put(salesForceID, emp);
				}
				// case where new employee id is found
				// we prepare a new arraylist for that employee to hold all his
				// requests on Financial Force file
				else {
					tempArrLst = new ArrayList<>();
					tempArrLst.add(attendanceOfLeave);
					salesforceDetailsMap.putIfAbsent(salesForceID, new EmployeeSalesforce(salesForceID, empName, tempArrLst));
				}
			}
		}

		allEmployeeSalesforceDetailList.setAsMap(salesforceDetailsMap);
	}
}
