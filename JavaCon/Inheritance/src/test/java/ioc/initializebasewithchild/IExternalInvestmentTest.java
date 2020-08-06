/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package ioc.initializebasewithchild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class IExternalInvestmentTest {

	@Test
	void init() throws Exception {
		IExternalInvestment.initAll();
	}

	/**
	 *
	 * init() was static so this means the object exists and persists and hence when the next call (below)
	 * can access the impl referred by "this"
	 * */
	@Test
	void main() throws Exception {
		String actual = OutsideUser.serviceCaller("Luke");
		Assertions.assertEquals("Luke, I'am Your Father!", actual);
	}
}