/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package onlineshopping.with_optional;

import onlineshopping.limited.ScreenResolution;

import java.util.Optional;

public class MobileTesterWithOptional {

	public static void main(String[] args) {
		ScreenResolution resolution = new ScreenResolution(750, 1334);
		DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
		Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));

		MobileService mService = new MobileService();

		int width = mService.getMobileScreenWidth(Optional.of(mobile));
		System.out.println("Apple iPhone 6s Screen Width = " + width);

		Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.empty());
		int width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
		System.out.println("Apple iPhone 16s Screen Width = " + width2);
	}
}