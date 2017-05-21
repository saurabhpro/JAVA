package com.saurabh.atm.util.generator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by saurabhkumar on 14/05/17.
 */
public class FirebaseUtilTest {
	@BeforeMethod
	public void setUp() throws Exception {
	}

	@Test
	public void testInit() throws Exception {
		FirebaseUtil firebaseUtil = new FirebaseUtil();
		firebaseUtil.init();
	}

}