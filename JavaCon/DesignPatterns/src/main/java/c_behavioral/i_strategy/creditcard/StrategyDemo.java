/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package c_behavioral.i_strategy.creditcard;

public class StrategyDemo {

	public static void main(String args[]) {
		CreditCard amexCard = new CreditCard(new AmexStrategy());

		amexCard.setNumber("379185883464283");
		amexCard.setDate("04/2020");
		amexCard.setCvv("123");

		System.out.println("Is Amex valid: " + amexCard.isValid());

		CreditCard amexCard2 = new CreditCard(new AmexStrategy());

		amexCard2.setNumber("379185883464282");
		amexCard2.setDate("04/2017");
		amexCard2.setCvv("234");

		System.out.println("Is Amex valid: " + amexCard2.isValid());

		CreditCard visaCard = new CreditCard(new VisaStrategy());

		visaCard.setNumber("4539589763663402");
		visaCard.setDate("05/2018");
		visaCard.setCvv("324");

		System.out.println("Is Visa valid: " + visaCard.isValid());
	}
}
