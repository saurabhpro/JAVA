package b_structural.a_adapter.emp.adapters;

import b_structural.a_adapter.emp.EmployeeCSV;
import b_structural.a_adapter.emp.legacy.Employee;

public class EmployeeAdapterCSV implements Employee {

	private EmployeeCSV instance;

	public EmployeeAdapterCSV(EmployeeCSV instance) {
		this.instance = instance;
	}

	@Override
	public String getId() {
		return instance.getId() + "";
	}

	@Override
	public String getFirstName() {
		return instance.getFirstname();
	}

	@Override
	public String getLastName() {
		return instance.getLastname();
	}

	@Override
	public String getEmail() {
		return instance.getEmailAddress();
	}

}
