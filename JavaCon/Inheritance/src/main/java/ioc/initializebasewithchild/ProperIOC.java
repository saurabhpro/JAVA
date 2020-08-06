/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package ioc.initializebasewithchild;

public class ProperIOC {

}

final class ExternalInvestmentHelper {

	private ExternalInvestmentHelper() {}

	public static ExternalInvestmentBase getExternalInvestment() {
		return ExternalInvestmentBase.sImpl;
	}

	public static ExternalInvestmentBase setExternalInvestment(ExternalInvestmentBase ei) {
		ExternalInvestmentBase.sImpl = ei;
		return ExternalInvestmentBase.sImpl;
	}

}