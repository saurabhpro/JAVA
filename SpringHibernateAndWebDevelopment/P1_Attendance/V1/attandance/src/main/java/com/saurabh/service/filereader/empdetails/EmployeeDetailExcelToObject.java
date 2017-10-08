package com.saurabh.service.filereader.empdetails;

import com.saurabh.api.ObjectEmptyException;
import com.saurabh.api.excel.read.XLSXReaderImpl;
import com.saurabh.api.json.JsonWriter;
import com.saurabh.entity.employee.Employee;
import com.saurabh.service.helper.RevalIdComparator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import static com.saurabh.service.helper.utility.constants.ProjectConstants.FILE_PATH;

/**
 * Created by saurabhkumar on 10/09/17.
 */
@Service
public class EmployeeDetailExcelToObject extends XLSXReaderImpl {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDetailExcelToObject.class);

	private static AllEmployeeDetailList allEmployeeDetailList = new AllEmployeeDetailList();
	private Sheet sheet = null;

	public static List<Employee> getAllEmployeeDetailList() {
		if (allEmployeeDetailList.getAsList().isEmpty()) {
			try {
				throw new ObjectEmptyException("employee details are not read since object is empty");
			} catch (ObjectEmptyException e) {
				e.printStackTrace();
			}
		}
		return allEmployeeDetailList.getAsList();
	}

	public static Map<String, Employee> getAllEmployeeDetailMap() {
		return allEmployeeDetailList.getAsMap();
	}

	public static Employee getEmployeeObjectFromId(String empId) {
		Map<String, Employee> employeeDetailsMap = allEmployeeDetailList.getAsMap();

		if (employeeDetailsMap.containsKey(empId))
			return employeeDetailsMap.get(empId);

		logger.warn("Employee Details Not Found for [" + empId + "] Since Object is Empty");

		/*try {
			throw new ObjectEmptyException("Employee Details Not Found for ["+ empId+"] Since Object is Empty");
		} catch (ObjectEmptyException e) {
			e.printStackTrace();
		}*/

		return null;
	}

	/**
	 * @param column the column number starting from 0 from which data is to be
	 *               retrieved
	 * @param row    the row number stating with 0 from which data is to be
	 *               retrieved
	 * @return return the contents for the cell specified by column and row
	 */
	private String getCustomCellContent(int column, int row) {
		Cell cell = sheet.getRow(row).getCell(column);

		//TODO rename getCellTypeEnum if apace.poi > 4.2
		if (cell.getCellTypeEnum() == CellType.NUMERIC)
			return Objects.toString((int) cell.getNumericCellValue()).trim();
		else
			return cell.getStringCellValue().trim();
	}

	/**
	 * method to convert the object map containing the all employees basic data
	 * record to Json files
	 */
	@Override
	public void toJsonFile(String filePath) {
		JsonWriter.writeUsingJackson(FILE_PATH + filePath, allEmployeeDetailList);
	}

	/**
	 * Reads the all employee basic record data like email id, name, reval id
	 * and corresponding Salesforce Id
	 */
	@Override
	public void readExcelFile(String filePath) {
		sheet = super.convertToSheet(filePath);
		Map<String, Employee> list = new TreeMap<>(new RevalIdComparator());

		int numberOfRowsInAllEmpDetailList = sheet.getPhysicalNumberOfRows();

		for (int row = 0; row < numberOfRowsInAllEmpDetailList; row++) {
			Employee b = new Employee();

			b.setName(getCustomCellContent(0, row));
			b.setEmailId(getCustomCellContent(1, row));
			b.setEmpId(getCustomCellContent(2, row));
			b.setSalesForceId(getCustomCellContent(3, row));

			if (!b.getEmpId().isEmpty())
				list.put(b.getEmpId(), b);
		}

		allEmployeeDetailList.setAsMap(list);
	}
}
