package b_structural.a_adapter.emp;

import java.util.StringTokenizer;

@SuppressWarnings("ALL")
public class EmployeeCSV {

	private int id;
	private String firstname;
	private String lastname;
	private String emailAddress;

	EmployeeCSV(String values) {
		StringTokenizer tokenizer = new StringTokenizer(values, ",");
		if (tokenizer.hasMoreElements()) {
			id = Integer.parseInt(tokenizer.nextToken());
		}
		if (tokenizer.hasMoreElements()) {
			firstname = tokenizer.nextToken();
		}
		if (tokenizer.hasMoreElements()) {
			lastname = tokenizer.nextToken();
		}
		if (tokenizer.hasMoreElements()) {
			emailAddress = tokenizer.nextToken();
		}
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
