package com.saurabh.atm.util.generator;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Date;
import java.util.OptionalInt;
import java.util.Random;

/**
 * Created by saurabhkumar on 08/05/17.
 * Code to generate 4 digit pin between [0000 - 9999]
 */
public class PINGenerator {
	private String pin;
	private ArrayList<String> archivedPin;

	public String getPin() {
		return pin;
	}

	public void setPin() {
		String newPin = generatePin();
		if (!hasAlreadyBeenIssued(newPin)) {
			this.archivedPin.add(this.pin);
			this.pin = newPin;
		}
	}

	@Contract(pure = true)
	private boolean hasAlreadyBeenIssued(String newPin) {
		for (String pin : this.archivedPin) {
			if (pin.equals(newPin)) {
				return false;
			}
		}
		return true;
	}

	private String generatePin() {
		Random random = new Random(new Date().getTime());
		String pin;
		OptionalInt randomNumber = random.ints(0, 9999).findAny();

		if (randomNumber.isPresent()) {
			if (randomNumber.getAsInt() < 1000)
				pin = padTo4Digits(randomNumber.getAsInt());
			else
				pin = String.valueOf(randomNumber.getAsInt());
		} else {
			throw new InstantiationError("no pin could be generated");
		}

		System.out.println("Your Pin = " + pin);
		return pin;
	}

	@org.jetbrains.annotations.NotNull
	private String padTo4Digits(int num) {
		int padCount;
		StringBuilder padString = new StringBuilder();
		if (num < 10)
			padCount = 3;
		else if (num < 100)
			padCount = 2;
		else
			padCount = 1;
		while (padCount-- > 0) {
			padString.append("0");
		}
		return padString.toString() + num;
	}
}
