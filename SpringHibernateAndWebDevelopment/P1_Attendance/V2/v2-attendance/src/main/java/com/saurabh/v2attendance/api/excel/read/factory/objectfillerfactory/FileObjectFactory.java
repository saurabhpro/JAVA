package com.saurabh.v2attendance.api.excel.read.factory.objectfillerfactory;

import com.saurabh.entity.employee.Employee;
import com.saurabh.entity.records.EmployeeBiometric;
import com.saurabh.entity.records.EmployeeSalesforce;

/**
 * Created by kumars on 4/20/2016.
 */
@Deprecated
public class FileObjectFactory {

	public Employee dispatch(String type) {
		switch (type) {
			case "Biometric":
				return new EmployeeBiometric();
			case "Hrnet":
				return new EmployeeSalesforce();
		}
		return null;
	}

}
