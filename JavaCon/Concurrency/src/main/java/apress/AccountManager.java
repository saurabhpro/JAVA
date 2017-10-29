/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package apress;

public class AccountManager {
	public final static int SAVINGS_ACCOUNT = 1;
	public final static int CHECKING_ACCOUNT = 2;

	public AccountManager(int transfers) {
		CustomerAccount savings = new CustomerAccount(SAVINGS_ACCOUNT, 1000);
		CustomerAccount checking = new CustomerAccount(CHECKING_ACCOUNT, 1000);

		java.text.NumberFormat formatter = java.text.NumberFormat.getCurrencyInstance(java.util.Locale.US);

		System.out.println("Total balance before transfers: " + formatter.format(savings.getBalance() + checking.getBalance()));

		TransferManager tm1 = new TransferManager(checking, savings, transfers);
		TransferManager tm2 = new TransferManager(savings, checking, transfers);

		// Create two threads
		Thread t1 = new Thread(tm1);
		Thread t2 = new Thread(tm2);

		// Initiate execution of the threads
		t1.start();
		t2.start();

		// Wait for both threads to complete execution
		try {
			t1.join();
			t2.join();
		} catch (Exception ignored) {
		}

		System.out.println("Total balance after transfers: " + formatter.format(savings.getBalance() + checking.getBalance()));
	}

	public static void main(String[] args) {
		int transfers = 1000000;
		try {
			transfers = Integer.parseInt(args[0]);
		} catch (Exception ignored) {
		}
		AccountManager am = new AccountManager(transfers);
	}

	class TransferManager implements Runnable {
		private CustomerAccount fromAccount;
		private CustomerAccount toAccount;
		private int transferCount;

		public TransferManager(CustomerAccount fromacct, CustomerAccount toacct, int transfers) {
			fromAccount = fromacct;
			toAccount = toacct;
			transferCount = transfers;
		}

		public void run() {
			double balance;
			double transferAmount;
			for (int i = 0; i < transferCount; i++) {
				balance = fromAccount.getBalance();
				transferAmount = balance * Math.random();

				balance -= transferAmount;
				fromAccount.setBalance(balance);

				balance = toAccount.getBalance();
				balance += transferAmount;
				toAccount.setBalance(balance);
			}
		}
	}

	class CustomerAccount {
		private int accountType;
		private double balance;

		public CustomerAccount(int type, double bal) {
			accountType = type;
			balance = bal;
		}

		public int getAccountType() {
			return accountType;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double newbal) {
			balance = newbal;
		}
	}
}