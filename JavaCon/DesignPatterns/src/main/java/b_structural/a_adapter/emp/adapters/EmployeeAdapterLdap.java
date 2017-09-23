package b_structural.a_adapter.emp.adapters;

import b_structural.a_adapter.emp.EmployeeLdap;
import b_structural.a_adapter.emp.legacy.Employee;

public class EmployeeAdapterLdap implements Employee {

	private final EmployeeLdap instance;

	public EmployeeAdapterLdap(EmployeeLdap instance) {
		this.instance = instance;
	}

	@Override
	public String getId() {
		return instance.getCn();
	}

	@Override
	public String getFirstName() {
		return instance.getGivenName();
	}

	@Override
	public String getLastName() {
		return instance.getSurname();
	}

	@Override
	public String getEmail() {
		return instance.getMail();
	}

	public String toString() {
		return "ID: " + instance.getCn();
	}

}
