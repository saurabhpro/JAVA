package c_behavioral.f_memento.serial;

import java.io.Serializable;

//originator
public class Employee implements Serializable {

	private String name;
	private String address;
	private String phone;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return name + " : " + phone;
	}
}