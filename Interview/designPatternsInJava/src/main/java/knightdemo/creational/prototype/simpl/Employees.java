package knightdemo.creational.prototype.simpl;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {

	private List<String> empList;

	public Employees() {
		empList = new ArrayList<>();
	}

	public void loadData() {
		//read all employees from database and put into the list
		empList.add("Pankaj");
		empList.add("Raj");
		empList.add("David");
		empList.add("Lisa");
	}

	public List<String> getEmpList() {
		return empList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Employees clone = (Employees) super.clone();

		List<String> temp = new ArrayList<>();
//		for (String s : this.getEmpList()) {
//			temp.add(s);
//		}
		temp.addAll(this.getEmpList());


		clone.empList = temp;

		return clone;
	}

}