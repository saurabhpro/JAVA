/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package ioc.initializebasewithchild;

interface IExternalInvestmen {
// todo
}

// class A(B')
abstract class ExternalInvestmentBase {
	static ExternalInvestmentBase sImpl;

	protected ExternalInvestmentBase() {
		sImpl = this;
	}

	public static String supply(String request) throws Exception {
		return sImpl.supplyImpl(request);
	}

	abstract String supplyImpl(String request)
			throws Exception;
}

// class B which has the actual impl
class InvestmentUtil extends ExternalInvestmentBase {

	public static void init() {
		new InvestmentUtil();
	}


	@Override
	public String supplyImpl(String name) throws Exception {
		return name + ", I'am Your Father!";
	}
}

// class C with takes care of the linkin
public class IExternalInvestment {
	public static void initAll() throws Exception {
		// this call the B constructor which internally call super() and then impl=this
		/*
		 * which means the creation of "this" actually happened as soon as we entered the constructor (***)
		 * and this = class B
		 */
		InvestmentUtil.init();
	}
}


// Caller Class
class OutsideUser {
	public static String serviceCaller(String name) throws Exception {
		/*
		 * init() was static so this means the object exists and persists and hence when the next call (below)
		 * can access the impl referred by "this"
		 * */
		return ExternalInvestmentBase.supply(name);
	}
}