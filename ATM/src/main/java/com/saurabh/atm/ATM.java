package com.saurabh.atm;

import com.saurabh.atm.util.generator.PINGenerator;

import java.util.Scanner;

/**
 * Created by saurabhkumar on 08/05/17.
 */
public class ATM {
	private static final Scanner keyBoardInput = new Scanner(System.in);

	public static void main(String[] args) {

		//PINGenerator.generatePin();
		String accountNumber, password, origBalance;
		int count = 0, menuOption = 0;
		double depositAmt, withdrawAmt, currentBal;
		boolean foundNonDigit;
		//loop that will count the number of login attempts
		//you make and will exit program if it is more than 3.
		//as long as oriBal equals an error.
		do {
			foundNonDigit = false;
			System.out.println("Please Enter Your Account Number: ");
			accountNumber = keyBoardInput.next();

			System.out.println("Enter Your Password: ");
			password = keyBoardInput.next();

			origBalance = ATMHelper.checkID(accountNumber, password);

			count++;

			if (count >= 3 && origBalance.equals("error")) {
				System.out.print("Maximum Login Attempts Reached.");
				System.exit(0);
			}
			if (!(origBalance.equals("error"))) {
				System.out.println("\nYour New Balance is: $ " + origBalance);
			} else
				System.out.println(origBalance);


		} while (origBalance.equals("error"));

		currentBal = Double.parseDouble(origBalance);
		//this loop will keep track of the options that
		//the user inputs in for the menu. and will
		//give the option of deposit, withdraw, or logout.

		while (menuOption != 4) {

			menuOption = ATM.menu();

			switch (menuOption) {
				case 1:
					ATMHelper.displayBalance(currentBal);
					break;
				case 2:
					System.out.print("\nEnter Amount You Wish to Deposit: $ ");
					depositAmt = keyBoardInput.nextDouble();
					currentBal = ATMHelper.deposit(depositAmt, currentBal);
					break;
				case 3:
					System.out.print("\nEnter Amount You Wish to Withdrawal: $ ");
					withdrawAmt = keyBoardInput.nextDouble();

					while (withdrawAmt > currentBal) {
						System.out.print("ERROR: INSUFFICIENT FUNDS!! "
								+ "PLEASE ENTER A DIFFERENT AMOUNT: $");
						withdrawAmt = keyBoardInput.nextDouble();
					}

					currentBal = ATMHelper.withdraw(currentBal, withdrawAmt);
					break;
				case 4:
					System.out.print("\nThank For Using My com.saurabh.atm.util.generator.ATM.  Have a Nice Day.  Good-Bye!");
					System.exit(0);
					break;
			}
		}
	}

	private static int menu() {
		int menuChoice;
		do {
			System.out.print("\nPlease Choose From the Following Options:"
					+ "\n 1. Display Balance \n 2. Deposit"
					+ "\n 3. Withdraw\n 4. Log Out\n\n");

			menuChoice = keyBoardInput.nextInt();

			if (menuChoice < 1 || menuChoice > 4) {
				System.out.println("error");
			}

		} while (menuChoice < 1 || menuChoice > 4);

		return menuChoice;
	}
}