/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package onlineshopping.without_optional;

import onlineshopping.limited.ScreenResolution;

public class MobileTesterWithoutOptional {

	public static void main(String[] args) {

		ScreenResolution resolution = new ScreenResolution(750, 1334);
		DisplayFeatures displayFeatures = new DisplayFeatures("4.7", resolution);
		Mobile mobile = new Mobile(2017001, "Apple", "iPhone 8", displayFeatures);

		MobileService mService = new MobileService();

		int mobileWidth = mService.getMobileScreenWidth(mobile);
		System.out.println("Apple iPhone 8 Screen Width = " + mobileWidth);

		/* have fun - make it show 0 */
		ScreenResolution resolution2 = new ScreenResolution(0, 0);
		DisplayFeatures displayFeatures1 = new DisplayFeatures("0", null); //make it fail

		Mobile mobile2 = new Mobile(2017001, "Apple", "iPhone 8S", displayFeatures1);
		int mobileWidth2 = mService.getMobileScreenWidth(mobile2);
		System.out.println("Apple iPhone 8S Screen Width = " + mobileWidth2);

	}

}