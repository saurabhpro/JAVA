package com.saurabh.atm;

/**
 * Created by saurabhkumar on 08/05/17.
 */
class ATMHelper {

	// The checkID method determines if acctNum is a valid account number
	// and pwd is the correct password for the account.  If the account information
	// is valid, the method returns the current account balance, as a string.
	// If the account information is invalid, the method returns the string "error".
	static String checkID(String acctNum, String pwd) {
		String result = "error";

		// Strings a, b, and c contain the valid account numbers and passwords.
		// For each string, the account number is listed first, followed by
		// a space, followed by the password for the account, followed by a space,
		// followed by the current balance.
		String a = "44567-5 mypassword 520.36";
		String b = "1234567-6 anotherpassword 48.20";
		String c = "4321-0 betterpassword 96.74";

		if (acctNum.equals(a.substring(0, a.indexOf(" "))) &&
				pwd.equals(a.substring(a.indexOf(" ") + 1, a.lastIndexOf(" "))))
			result = a.substring(a.lastIndexOf(" ") + 1);

		else if (acctNum.equals(b.substring(0, b.indexOf(" "))) &&
				pwd.equals(b.substring(b.indexOf(" ") + 1, b.lastIndexOf(" "))))
			result = b.substring(b.lastIndexOf(" ") + 1);

		else if (acctNum.equals(c.substring(0, c.indexOf(" "))) &&
				pwd.equals(c.substring(c.indexOf(" ") + 1, c.lastIndexOf(" "))))
			result = c.substring(c.lastIndexOf(" ") + 1);

		return result;
	}

	static void displayBalance(double x) {
		System.out.printf("\nYour Current Balance is $%.2f\n", x);
	}

	static double deposit(double depositAmt, double currentBal) {
		double newBalance = depositAmt + currentBal;

		System.out.printf("Your New Balance is $%.2f\n", newBalance);

		return newBalance;
	}

	static double withdraw(double withdrawAmt, double currentBal) {
		double newBalance = currentBal - withdrawAmt;
		System.out.printf("Your New Balance is %.2f\n", newBalance);

		return newBalance;
	}
}
