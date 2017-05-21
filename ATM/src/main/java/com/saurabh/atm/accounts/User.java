package com.saurabh.atm.accounts;

/**
 * Created by saurabhkumar on 08/05/17.
 */
public class User {
	private String username;
	private int pin;


	public User(String username, int pin) {
		super();
		this.username = username;
		this.pin = pin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", pin=" + pin + "]";
	}


}
