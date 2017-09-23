package c_behavioral.f_memento.history;

import java.util.Stack;

//caretaker
class Caretaker {

	private final Stack<EmployeeMemento> employeeHistory = new Stack<>();

	public void save(Employee emp) {
		employeeHistory.push(emp.save());
	}

	public void revert(Employee emp) {
		emp.revert(employeeHistory.pop());
	}
}
