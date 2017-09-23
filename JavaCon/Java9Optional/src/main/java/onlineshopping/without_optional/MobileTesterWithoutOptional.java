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