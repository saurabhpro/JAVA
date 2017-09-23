/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.whatsnew.demo04.langandlib.language;

public interface PricedObject {
	// Private fields are not allowed
	// private double TAX = 1.21;

	private static double getTax() {
		return 1.21;
	}

	double getPrice();

	default double getPriceWithTax() {
		return getTaxedPriceInternal();
	}

	default double getOfferPrice(double discount) {
		return getTaxedPriceInternal() * discount;
	}

	private double getTaxedPriceInternal() {
		return getPrice() * getTax();
	}

    /* Before private interface methods, shared logic could not be extracted into a
       new method (at least not without it becoming part of the public API).

    default double getPriceWithTax() {
        return getPrice() * 1.21;
    }

    default double getOfferPrice(double discount) {
        return getPrice() * 1.21 * discount;
    }
    */
}
